configuration CollectionStarterC { }

implementation
{
    components CollectionC, AutoStarterStdControlC;

    AutoStarterStdControlC.StdControl -> CollectionC;
}
