/* Copyright (c) 2007 Johns Hopkins University.
 *  All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 * - Redistributions of source code must retain the above copyright
 *   notice, this list of conditions and the following disclaimer.
 * - Redistributions in binary form must reproduce the above copyright
 *   notice, this list of conditions and the following disclaimer in the
 *   documentation and/or other materials provided with the
 *   distribution.
 * - Neither the name of the copyright holders nor the names of
 *   its contributors may be used to endorse or promote products derived
 *   from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS
 * FOR A PARTICULAR PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL
 * THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT,
 * INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
 * HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT,
 * STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED
 * OF THE POSSIBILITY OF SUCH DAMAGE.
 */

/**
 * @author Chieh-Jan Mike Liang <cliang4@cs.jhu.edu>
 * @author Razvan Musaloiu-E. <razvanm@cs.jhu.edu>
 */

#ifndef __DELUGE_H__
#define __DELUGE_H__

typedef nx_struct DelugeIdent {
    nx_uint32_t  uidhash;        // unique id of the image
    nx_uint32_t  size;           // size of the whole image (ident + CRCs + binary)
    nx_uint8_t   numPgs;         // number of pages of complete image
    nx_uint8_t   reserved;
    nx_uint16_t  crc;            // crc over the above 4 fields
    nx_uint8_t   appname[16];
    nx_uint8_t   username[16];
    nx_uint8_t   hostname[16];
    nx_uint8_t   platform[16];
    nx_uint32_t  timestamp;
    nx_uint32_t  userhash;
} DelugeIdent;

enum {
    DELUGE_INVALID_UID = 0xffffffff,
    DELUGE_NUM_VOLUMES = 4, 
    DELUGE_KEY = 0xDE00,
    DELUGE_AM_FLASH_VOL_MANAGER = 0x53,
    DELUGE_AM_DELUGE_MANAGER = 0x54,
    DELUGE_AM_NODE_STATUS = 0x55,
    AM_NODESTATUS = DELUGE_AM_NODE_STATUS, // Redundant but needed for MIG tool
    DELUGE_COL_NODE_STATUS = 0x22
};

enum {
    DELUGE_CMD_STOP = 1,
    DELUGE_CMD_LOCAL_STOP = 2,
    DELUGE_CMD_ONLY_DISSEMINATE = 3,
    DELUGE_CMD_DISSEMINATE_AND_REPROGRAM = 4,       // Reprogram/reboot all nodes
    DELUGE_CMD_REPROGRAM = 5,                       // Reprogram the local mote
    DELUGE_CMD_REBOOT = 6,                          // Reboot the local mode
    DELUGE_CMD_DISSEMINATE_AND_REPROGRAM_NODES = 7, // Reprogram/Reboot nodes set in "nodeIds" hash
    DELUGE_CMD_DISSEMINATE_AND_REPROGRAM_GROUP = 8, // Reprogram/Reboot nodes matching "groupId"
    DELUGE_CMD_UPDATE_GROUP = 9                     // Update nodes groupId
};

// Warn the user if the DELUGE_GROUP_ID_DEFAULT is not set
#ifndef DELUGE_GROUP_ID_DEFAULT 
    #define DELUGE_GROUP_ID_DEFAULT 1
    #warning "Default DELUGE_GROUP_ID_DEFAULT set (value = 1)"
#endif

// Set the DELUGE_GROUP_ID to the preprocessor value
uint8_t DELUGE_GROUP_ID = DELUGE_GROUP_ID_DEFAULT;

// NodeStatus payload used by the Collection component
// Each mote sends a status of its current state and running application
typedef nx_struct NodeStatus {
    nx_uint16_t nodeId;       // Mote's TOS_NODE_ID
    nx_uint8_t groupId;       // Mote's DELUGE_GROUP_ID
    nx_uint8_t state;         // Mote's current statue (S_IDLE, S_PUB, S_RECV)
    nx_uint32_t appUid;       // Mote's running application unique id
    nx_uint8_t appName[8];    // Mote's running application name
    nx_uint32_t appTimeStamp; // Mote's running application compiled time (seconds since epoch)
} NodeStatus;


#define UQ_DELUGE_METADATA "DelugeMetadata.client"
#define UQ_DELUGE_VOLUME_MANAGER "DelugeVolumeManager.client"

typedef nx_struct DelugeCmd {
    nx_uint8_t type;
    nx_uint32_t uidhash;  // unique id of image
    nx_uint8_t  imgNum;   // image number
    nx_uint32_t size;     // size of the image
    nx_uint32_t nodeIds;  // Nodes to update (hash)
    nx_uint8_t groupId;   // Group id
} DelugeCmd;

typedef struct BootArgs {
    uint16_t  address;     // Mote's TOS_NODE_ID
    uint32_t imageAddr;    // Image address to boot
    uint8_t  gestureCount; // Counter used to reset mote to GoldenImage
    bool     noReprogram;  // Field used to reset mote to GoldenImage
    uint8_t groupId;       // Mote's DELUGE_GROUP_ID
} BootArgs;

#endif
