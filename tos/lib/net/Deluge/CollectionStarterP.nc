module CollectionStarterP
{
    uses
    {
        interface Boot;
        interface StdControl;
        interface RootControl;
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
        call RootControl.setRoot();
#endif

    }
}
