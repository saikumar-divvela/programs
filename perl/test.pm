#!/usr/bin/perl

sub findspecs {
    my ($files) = @_;
    

    #print "$files\n";    
    #foreach my $key (keys %$files) {
    #    print "$key $files->{$key}\n";
    #}*/

    my %files = map {$_ => [$files->{$_},$_] } keys %$files;
    my @specs =  grep { $_ =~ /spec/ } keys %files;

    my %oh;
    foreach (@specs)
    {
        $oh{$_} =  $files->{$_};
    }

    #foreach my $key (keys %oh) {
    #    print "$key $oh->{$key}\n";
    #}
    return %oh;
}

my %h;
$h{'_service:gbs:multiprofile-common-profile.spec'} = 'e36c68e4810303983f138255bbd969ae';
$h{'_service:gbs:multiprofile.spec'} = '5de8004c40e5d910c7996dd92856b176';
$h{'key1'} = 'value1';
$h{'key2'} = 'value2';
$h{'key3'} = 'value3';

my $ref = \%h;
my %oh = findspecs($ref);
print %oh;

my @test = (1,2,3);

print "\n";
foreach (@test){
    print "$_";
}

