module CollectionStarterP
{
    uses
    {
        interface Boot;
        interface StdControl;
        interface RootControl;
        interface Leds;
    }
}

implementation
{
    event void Boot.booted()
    {
        //Start the Collection service
        call StdControl.start();

        //Set as root if BASESTATION
#ifdef DELUGE_BASESTATION
        call Leds.led2Toggle();
        if(call RootControl.setRoot() != SUCCESS)
        {
            call Leds.led0Toggle();
        }
#endif

    }
}
