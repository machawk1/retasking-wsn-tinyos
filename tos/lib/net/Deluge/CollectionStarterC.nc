configuration CollectionStarterC { }

implementation
{
    components MainC, CollectionC, CollectionStarterP;

    CollectionStarterP.Boot -> MainC;
    CollectionStarterP.StdControl -> CollectionC;
    CollectionStarterP.RootControl -> CollectionC;
}
