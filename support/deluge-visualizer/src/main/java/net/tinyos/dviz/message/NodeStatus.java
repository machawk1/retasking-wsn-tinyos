/**
 * This class is automatically generated by mig. DO NOT EDIT THIS FILE.
 * This class implements a Java interface to the 'NodeStatus'
 * message type.
 */

package net.tinyos.dviz.message;

public class NodeStatus extends net.tinyos.message.Message {

    /** The default size of this message type in bytes. */
    public static final int DEFAULT_MESSAGE_SIZE = 20;

    /** The Active Message type associated with this message. */
    public static final int AM_TYPE = 85;

    /** Create a new NodeStatus of size 20. */
    public NodeStatus() {
        super(DEFAULT_MESSAGE_SIZE);
        amTypeSet(AM_TYPE);
    }

    /** Create a new NodeStatus of the given data_length. */
    public NodeStatus(int data_length) {
        super(data_length);
        amTypeSet(AM_TYPE);
    }

    /**
     * Create a new NodeStatus with the given data_length
     * and base offset.
     */
    public NodeStatus(int data_length, int base_offset) {
        super(data_length, base_offset);
        amTypeSet(AM_TYPE);
    }

    /**
     * Create a new NodeStatus using the given byte array
     * as backing store.
     */
    public NodeStatus(byte[] data) {
        super(data);
        amTypeSet(AM_TYPE);
    }

    /**
     * Create a new NodeStatus using the given byte array
     * as backing store, with the given base offset.
     */
    public NodeStatus(byte[] data, int base_offset) {
        super(data, base_offset);
        amTypeSet(AM_TYPE);
    }

    /**
     * Create a new NodeStatus using the given byte array
     * as backing store, with the given base offset and data length.
     */
    public NodeStatus(byte[] data, int base_offset, int data_length) {
        super(data, base_offset, data_length);
        amTypeSet(AM_TYPE);
    }

    /**
     * Create a new NodeStatus embedded in the given message
     * at the given base offset.
     */
    public NodeStatus(net.tinyos.message.Message msg, int base_offset) {
        super(msg, base_offset, DEFAULT_MESSAGE_SIZE);
        amTypeSet(AM_TYPE);
    }

    /**
     * Create a new NodeStatus embedded in the given message
     * at the given base offset and length.
     */
    public NodeStatus(net.tinyos.message.Message msg, int base_offset, int data_length) {
        super(msg, base_offset, data_length);
        amTypeSet(AM_TYPE);
    }

    /**
    /* Return a String representation of this message. Includes the
     * message type name and the non-indexed field values.
     */
    public String toString() {
      String s = "Message <NodeStatus> \n";
      try {
        s += "  [nodeId=0x"+Long.toHexString(get_nodeId())+"]\n";
      } catch (ArrayIndexOutOfBoundsException aioobe) { /* Skip field */ }
      try {
        s += "  [groupId=0x"+Long.toHexString(get_groupId())+"]\n";
      } catch (ArrayIndexOutOfBoundsException aioobe) { /* Skip field */ }
      try {
        s += "  [state=0x"+Long.toHexString(get_state())+"]\n";
      } catch (ArrayIndexOutOfBoundsException aioobe) { /* Skip field */ }
      try {
        s += "  [appUid=0x"+Long.toHexString(get_appUid())+"]\n";
      } catch (ArrayIndexOutOfBoundsException aioobe) { /* Skip field */ }
      try {
        s += "  [appName=";
        for (int i = 0; i < 8; i++) {
          s += "0x"+Long.toHexString(getElement_appName(i) & 0xff)+" ";
        }
        s += "]\n";
      } catch (ArrayIndexOutOfBoundsException aioobe) { /* Skip field */ }
      try {
        s += "  [appTimeStamp=0x"+Long.toHexString(get_appTimeStamp())+"]\n";
      } catch (ArrayIndexOutOfBoundsException aioobe) { /* Skip field */ }
      return s;
    }

    // Message-type-specific access methods appear below.

    /////////////////////////////////////////////////////////
    // Accessor methods for field: nodeId
    //   Field type: int, unsigned
    //   Offset (bits): 0
    //   Size (bits): 16
    /////////////////////////////////////////////////////////

    /**
     * Return whether the field 'nodeId' is signed (false).
     */
    public static boolean isSigned_nodeId() {
        return false;
    }

    /**
     * Return whether the field 'nodeId' is an array (false).
     */
    public static boolean isArray_nodeId() {
        return false;
    }

    /**
     * Return the offset (in bytes) of the field 'nodeId'
     */
    public static int offset_nodeId() {
        return (0 / 8);
    }

    /**
     * Return the offset (in bits) of the field 'nodeId'
     */
    public static int offsetBits_nodeId() {
        return 0;
    }

    /**
     * Return the value (as a int) of the field 'nodeId'
     */
    public int get_nodeId() {
        return (int)getUIntBEElement(offsetBits_nodeId(), 16);
    }

    /**
     * Set the value of the field 'nodeId'
     */
    public void set_nodeId(int value) {
        setUIntBEElement(offsetBits_nodeId(), 16, value);
    }

    /**
     * Return the size, in bytes, of the field 'nodeId'
     */
    public static int size_nodeId() {
        return (16 / 8);
    }

    /**
     * Return the size, in bits, of the field 'nodeId'
     */
    public static int sizeBits_nodeId() {
        return 16;
    }

    /////////////////////////////////////////////////////////
    // Accessor methods for field: groupId
    //   Field type: short, unsigned
    //   Offset (bits): 16
    //   Size (bits): 8
    /////////////////////////////////////////////////////////

    /**
     * Return whether the field 'groupId' is signed (false).
     */
    public static boolean isSigned_groupId() {
        return false;
    }

    /**
     * Return whether the field 'groupId' is an array (false).
     */
    public static boolean isArray_groupId() {
        return false;
    }

    /**
     * Return the offset (in bytes) of the field 'groupId'
     */
    public static int offset_groupId() {
        return (16 / 8);
    }

    /**
     * Return the offset (in bits) of the field 'groupId'
     */
    public static int offsetBits_groupId() {
        return 16;
    }

    /**
     * Return the value (as a short) of the field 'groupId'
     */
    public short get_groupId() {
        return (short)getUIntBEElement(offsetBits_groupId(), 8);
    }

    /**
     * Set the value of the field 'groupId'
     */
    public void set_groupId(short value) {
        setUIntBEElement(offsetBits_groupId(), 8, value);
    }

    /**
     * Return the size, in bytes, of the field 'groupId'
     */
    public static int size_groupId() {
        return (8 / 8);
    }

    /**
     * Return the size, in bits, of the field 'groupId'
     */
    public static int sizeBits_groupId() {
        return 8;
    }

    /////////////////////////////////////////////////////////
    // Accessor methods for field: state
    //   Field type: short, unsigned
    //   Offset (bits): 24
    //   Size (bits): 8
    /////////////////////////////////////////////////////////

    /**
     * Return whether the field 'state' is signed (false).
     */
    public static boolean isSigned_state() {
        return false;
    }

    /**
     * Return whether the field 'state' is an array (false).
     */
    public static boolean isArray_state() {
        return false;
    }

    /**
     * Return the offset (in bytes) of the field 'state'
     */
    public static int offset_state() {
        return (24 / 8);
    }

    /**
     * Return the offset (in bits) of the field 'state'
     */
    public static int offsetBits_state() {
        return 24;
    }

    /**
     * Return the value (as a short) of the field 'state'
     */
    public short get_state() {
        return (short)getUIntBEElement(offsetBits_state(), 8);
    }

    /**
     * Set the value of the field 'state'
     */
    public void set_state(short value) {
        setUIntBEElement(offsetBits_state(), 8, value);
    }

    /**
     * Return the size, in bytes, of the field 'state'
     */
    public static int size_state() {
        return (8 / 8);
    }

    /**
     * Return the size, in bits, of the field 'state'
     */
    public static int sizeBits_state() {
        return 8;
    }

    /////////////////////////////////////////////////////////
    // Accessor methods for field: appUid
    //   Field type: long, unsigned
    //   Offset (bits): 32
    //   Size (bits): 32
    /////////////////////////////////////////////////////////

    /**
     * Return whether the field 'appUid' is signed (false).
     */
    public static boolean isSigned_appUid() {
        return false;
    }

    /**
     * Return whether the field 'appUid' is an array (false).
     */
    public static boolean isArray_appUid() {
        return false;
    }

    /**
     * Return the offset (in bytes) of the field 'appUid'
     */
    public static int offset_appUid() {
        return (32 / 8);
    }

    /**
     * Return the offset (in bits) of the field 'appUid'
     */
    public static int offsetBits_appUid() {
        return 32;
    }

    /**
     * Return the value (as a long) of the field 'appUid'
     */
    public long get_appUid() {
        return (long)getUIntBEElement(offsetBits_appUid(), 32);
    }

    /**
     * Set the value of the field 'appUid'
     */
    public void set_appUid(long value) {
        setUIntBEElement(offsetBits_appUid(), 32, value);
    }

    /**
     * Return the size, in bytes, of the field 'appUid'
     */
    public static int size_appUid() {
        return (32 / 8);
    }

    /**
     * Return the size, in bits, of the field 'appUid'
     */
    public static int sizeBits_appUid() {
        return 32;
    }

    /////////////////////////////////////////////////////////
    // Accessor methods for field: appName
    //   Field type: short[], unsigned
    //   Offset (bits): 64
    //   Size of each element (bits): 8
    /////////////////////////////////////////////////////////

    /**
     * Return whether the field 'appName' is signed (false).
     */
    public static boolean isSigned_appName() {
        return false;
    }

    /**
     * Return whether the field 'appName' is an array (true).
     */
    public static boolean isArray_appName() {
        return true;
    }

    /**
     * Return the offset (in bytes) of the field 'appName'
     */
    public static int offset_appName(int index1) {
        int offset = 64;
        if (index1 < 0 || index1 >= 8) throw new ArrayIndexOutOfBoundsException();
        offset += 0 + index1 * 8;
        return (offset / 8);
    }

    /**
     * Return the offset (in bits) of the field 'appName'
     */
    public static int offsetBits_appName(int index1) {
        int offset = 64;
        if (index1 < 0 || index1 >= 8) throw new ArrayIndexOutOfBoundsException();
        offset += 0 + index1 * 8;
        return offset;
    }

    /**
     * Return the entire array 'appName' as a short[]
     */
    public short[] get_appName() {
        short[] tmp = new short[8];
        for (int index0 = 0; index0 < numElements_appName(0); index0++) {
            tmp[index0] = getElement_appName(index0);
        }
        return tmp;
    }

    /**
     * Set the contents of the array 'appName' from the given short[]
     */
    public void set_appName(short[] value) {
        for (int index0 = 0; index0 < value.length; index0++) {
            setElement_appName(index0, value[index0]);
        }
    }

    /**
     * Return an element (as a short) of the array 'appName'
     */
    public short getElement_appName(int index1) {
        return (short)getUIntBEElement(offsetBits_appName(index1), 8);
    }

    /**
     * Set an element of the array 'appName'
     */
    public void setElement_appName(int index1, short value) {
        setUIntBEElement(offsetBits_appName(index1), 8, value);
    }

    /**
     * Return the total size, in bytes, of the array 'appName'
     */
    public static int totalSize_appName() {
        return (64 / 8);
    }

    /**
     * Return the total size, in bits, of the array 'appName'
     */
    public static int totalSizeBits_appName() {
        return 64;
    }

    /**
     * Return the size, in bytes, of each element of the array 'appName'
     */
    public static int elementSize_appName() {
        return (8 / 8);
    }

    /**
     * Return the size, in bits, of each element of the array 'appName'
     */
    public static int elementSizeBits_appName() {
        return 8;
    }

    /**
     * Return the number of dimensions in the array 'appName'
     */
    public static int numDimensions_appName() {
        return 1;
    }

    /**
     * Return the number of elements in the array 'appName'
     */
    public static int numElements_appName() {
        return 8;
    }

    /**
     * Return the number of elements in the array 'appName'
     * for the given dimension.
     */
    public static int numElements_appName(int dimension) {
      int array_dims[] = { 8,  };
        if (dimension < 0 || dimension >= 1) throw new ArrayIndexOutOfBoundsException();
        if (array_dims[dimension] == 0) throw new IllegalArgumentException("Array dimension "+dimension+" has unknown size");
        return array_dims[dimension];
    }

    /**
     * Fill in the array 'appName' with a String
     */
    public void setString_appName(String s) { 
         int len = s.length();
         int i;
         for (i = 0; i < len; i++) {
             setElement_appName(i, (short)s.charAt(i));
         }
         setElement_appName(i, (short)0); //null terminate
    }

    /**
     * Read the array 'appName' as a String
     */
    public String getString_appName() { 
         char carr[] = new char[Math.min(net.tinyos.message.Message.MAX_CONVERTED_STRING_LENGTH,8)];
         int i;
         for (i = 0; i < carr.length; i++) {
             if ((char)getElement_appName(i) == (char)0) break;
             carr[i] = (char)getElement_appName(i);
         }
         return new String(carr,0,i);
    }

    /////////////////////////////////////////////////////////
    // Accessor methods for field: appTimeStamp
    //   Field type: long, unsigned
    //   Offset (bits): 128
    //   Size (bits): 32
    /////////////////////////////////////////////////////////

    /**
     * Return whether the field 'appTimeStamp' is signed (false).
     */
    public static boolean isSigned_appTimeStamp() {
        return false;
    }

    /**
     * Return whether the field 'appTimeStamp' is an array (false).
     */
    public static boolean isArray_appTimeStamp() {
        return false;
    }

    /**
     * Return the offset (in bytes) of the field 'appTimeStamp'
     */
    public static int offset_appTimeStamp() {
        return (128 / 8);
    }

    /**
     * Return the offset (in bits) of the field 'appTimeStamp'
     */
    public static int offsetBits_appTimeStamp() {
        return 128;
    }

    /**
     * Return the value (as a long) of the field 'appTimeStamp'
     */
    public long get_appTimeStamp() {
        return (long)getUIntBEElement(offsetBits_appTimeStamp(), 32);
    }

    /**
     * Set the value of the field 'appTimeStamp'
     */
    public void set_appTimeStamp(long value) {
        setUIntBEElement(offsetBits_appTimeStamp(), 32, value);
    }

    /**
     * Return the size, in bytes, of the field 'appTimeStamp'
     */
    public static int size_appTimeStamp() {
        return (32 / 8);
    }

    /**
     * Return the size, in bits, of the field 'appTimeStamp'
     */
    public static int sizeBits_appTimeStamp() {
        return 32;
    }

}
