configuration CollectionStarterC { }

implementation
{
    components MainC, CollectionC, CollectionStarterP, LedsC;;

    CollectionStarterP.Boot -> MainC;
    CollectionStarterP.StdControl -> CollectionC;
    CollectionStarterP.RootControl -> CollectionC;
    CollectionStarterP.Leds -> LedsC;
}
