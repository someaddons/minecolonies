package com.minecolonies.api.configuration;

import net.minecraftforge.common.ForgeConfigSpec;

/**
 * Mod server configuration.
 * Loaded serverside, synced on connection.
 */
public class ServerConfiguration extends AbstractConfiguration
{
    @Config.Comment("All configurations related to citizen names")
    public static Names names = new Names();

    public static class Names
    {
        @Config.Comment("Generate a middle initial when creating new colonist names")
        public boolean useMiddleInitial = true;

        @Config.Comment("Male first names to be used for colonists")
        public String[] maleFirstNames = new String[]
                                           {
                                             "Aaron",
                                             "Adam",
                                             "Adrian",
                                             "Aidan",
                                             "Aiden",
                                             "Alain",
                                             "Alex",
                                             "Alexander",
                                             "Andrew",
                                             "Anthony",
                                             "Asher",
                                             "Austin",
                                             "Benjamin",
                                             "Brayden",
                                             "Bryson",
                                             "Caden",
                                             "Caleb",
                                             "Callum",
                                             "Camden",
                                             "Cameron",
                                             "Carson",
                                             "Carter",
                                             "Charles",
                                             "Charlie",
                                             "Chase",
                                             "Christian",
                                             "Christopher",
                                             "Cole",
                                             "Colton",
                                             "Connor",
                                             "Cooper",
                                             "Curtis",
                                             "Cyrille",
                                             "Damian",
                                             "Daniel",
                                             "David",
                                             "Declan",
                                             "Diego",
                                             "Diogo",
                                             "Dominic",
                                             "Duarte",
                                             "Dylan",
                                             "Easton",
                                             "Eli",
                                             "Elias",
                                             "Elijah",
                                             "Elliot",
                                             "Ethan",
                                             "Evan",
                                             "Ezra",
                                             "Félix",
                                             "Gabriel",
                                             "Gavin",
                                             "George",
                                             "Grayson",
                                             "Guewen",
                                             "Harrison",
                                             "Henrik",
                                             "Henry",
                                             "Houston",
                                             "Hudson",
                                             "Hugo",
                                             "Hunter",
                                             "Ian",
                                             "Isaac",
                                             "Isaiah",
                                             "Jack",
                                             "Jackson",
                                             "Jacob",
                                             "James",
                                             "Jason",
                                             "Jayce",
                                             "Jayden",
                                             "Jeremiah",
                                             "Jim",
                                             "Joel",
                                             "John",
                                             "Jonathan",
                                             "Jordan",
                                             "Joseph",
                                             "Joshua",
                                             "Josiah",
                                             "Julian",
                                             "Kai",
                                             "Karsen",
                                             "Kevin",
                                             "Kian",
                                             "Landon",
                                             "Leo",
                                             "Levi",
                                             "Liam",
                                             "Lincoln",
                                             "Logan",
                                             "Luís",
                                             "Lucas",
                                             "Luke",
                                             "Mark",
                                             "Mason",
                                             "Mateo",
                                             "Matthew",
                                             "Max",
                                             "Michael",
                                             "Miles",
                                             "Muhammad",
                                             "Nathan",
                                             "Nathanael",
                                             "Nicholas",
                                             "Noah",
                                             "Nolan",
                                             "Oliver",
                                             "Oscar",
                                             "Owen",
                                             "Parker",
                                             "Paul",
                                             "Peter",
                                             "Philibert",
                                             "Rénald",
                                             "Ray",
                                             "Richard",
                                             "Robert",
                                             "Rory",
                                             "Roxan",
                                             "Ryan",
                                             "Samuel",
                                             "Sebastian",
                                             "Steven",
                                             "Thaddee",
                                             "Thomas",
                                             "Tiago",
                                             "Tristan",
                                             "Tyler",
                                             "William",
                                             "Wyatt",
                                             "Xavier",
                                             "Zachary",
                                             "Zane",
                                             "Abraham",
                                             "Allen",
                                             "Ambrose",
                                             "Arthur",
                                             "Avery",
                                             "Barnaby",
                                             "Bartholomew",
                                             "Benedict",
                                             "Bernard",
                                             "Cuthbert",
                                             "Edmund",
                                             "Edward",
                                             "Francis",
                                             "Fulke",
                                             "Geoffrey",
                                             "Gerard",
                                             "Gilbert",
                                             "Giles",
                                             "Gregory",
                                             "Hugh",
                                             "Humphrey",
                                             "Jerome",
                                             "Lancelot",
                                             "Lawrence",
                                             "Leonard",
                                             "Martin",
                                             "Mathias",
                                             "Nathaniel",
                                             "Oswyn",
                                             "Philip",
                                             "Piers",
                                             "Ralph",
                                             "Reynold",
                                             "Roger",
                                             "Rowland",
                                             "Simon",
                                             "Solomon",
                                             "Stephen",
                                             "Tobias",
                                             "Walter",
                                             "William"
                                           };

        @Config.Comment("Female first names to be used for colonists")
        public String[] femaleFirstNames = new String[]
                                             {
                                               "Aaliyah",
                                               "Abigail",
                                               "Adalyn",
                                               "Addison",
                                               "Adeline",
                                               "Alaina",
                                               "Alexandra",
                                               "Alice",
                                               "Allison",
                                               "Alyssa",
                                               "Amelia",
                                               "Anastasia",
                                               "Anna",
                                               "Annabelle",
                                               "Aria",
                                               "Arianna",
                                               "Aubrey",
                                               "Audrey",
                                               "Aurora",
                                               "Ava",
                                               "Bailey",
                                               "Barbara",
                                               "Bella",
                                               "Betty",
                                               "Brooklyn",
                                               "Callie",
                                               "Camilla",
                                               "Caroline",
                                               "Charlotte",
                                               "Chloe",
                                               "Claire",
                                               "Cora",
                                               "Daniela",
                                               "Diana",
                                               "Dorothy",
                                               "Eleanor",
                                               "Elena",
                                               "Eliana",
                                               "Elizabeth",
                                               "Ella",
                                               "Ellie",
                                               "Emilia",
                                               "Emilienne",
                                               "Emily",
                                               "Emma",
                                               "Eva",
                                               "Evelyn",
                                               "Everly",
                                               "Filipa",
                                               "Frédérique",
                                               "Gabriella",
                                               "Gianna",
                                               "Grace",
                                               "Hailey",
                                               "Hannah",
                                               "Harper",
                                               "Haylie",
                                               "Hazel",
                                               "Helen",
                                               "Isabella",
                                               "Isabelle",
                                               "Jade",
                                               "Jasmine",
                                               "Jennifer",
                                               "Jocelyn",
                                               "Jordyn",
                                               "Julia",
                                               "Juliana",
                                               "Julienne",
                                               "Karen",
                                               "Katia",
                                               "Kaylee",
                                               "Keira",
                                               "Kennedy",
                                               "Kinsley",
                                               "Kylie",
                                               "Layla",
                                               "Leah",
                                               "Lena",
                                               "Lila",
                                               "Liliana",
                                               "Lillian",
                                               "Lily",
                                               "Linda",
                                               "Lisa",
                                               "London",
                                               "Lorena",
                                               "Luana",
                                               "Lucy",
                                               "Luna",
                                               "Mélanie",
                                               "Mackenzie",
                                               "Madelyn",
                                               "Madison",
                                               "Maisy",
                                               "Makayla",
                                               "Margaret",
                                               "Maria",
                                               "Marine",
                                               "Mary",
                                               "Maya",
                                               "Melanie",
                                               "Mia",
                                               "Mila",
                                               "Nancy",
                                               "Natalie",
                                               "Natasha",
                                               "Niamh",
                                               "Nora",
                                               "Odile",
                                               "Olivia",
                                               "Paisley",
                                               "Paloma",
                                               "Paola",
                                               "Patricia",
                                               "Penelope",
                                               "Peyton",
                                               "Prudence",
                                               "Reagan",
                                               "Riley",
                                               "Sadie",
                                               "Samantha",
                                               "Sarah",
                                               "Savannah",
                                               "Scarlett",
                                               "Skyler",
                                               "Sophia",
                                               "Sophie",
                                               "Stella",
                                               "Susan",
                                               "Vérane",
                                               "Vera",
                                               "Victoria",
                                               "Violet",
                                               "Vivian",
                                               "Zoe",
                                               "Agnes",
                                               "Amy",
                                               "Anne",
                                               "Avis",
                                               "Beatrice",
                                               "Blanche",
                                               "Bridget",
                                               "Catherine",
                                               "Cecily",
                                               "Charity",
                                               "Christina",
                                               "Clemence",
                                               "Constance",
                                               "Denise",
                                               "Edith",
                                               "Elinor",
                                               "Ellen",
                                               "Florence",
                                               "Fortune",
                                               "Frances",
                                               "Frideswide",
                                               "Gillian",
                                               "Isabel",
                                               "Jane",
                                               "Janet",
                                               "Joan",
                                               "Josian",
                                               "Joyce",
                                               "Judith",
                                               "Katherine",
                                               "Lettice",
                                               "Mabel",
                                               "Margery",
                                               "Marion",
                                               "Martha",
                                               "Maud",
                                               "Mildred",
                                               "Millicent",
                                               "Parnell",
                                               "Philippa",
                                               "Rachel",
                                               "Rebecca",
                                               "Rose",
                                               "Ruth",
                                               "Susanna",
                                               "Sybil",
                                               "Thomasin",
                                               "Ursula",
                                               "Wilmot",
                                               "Winifred"
                                             };

        @Config.Comment("Last names to be used for colonists")
        public String[] lastNames = new String[]
                                      {
                                        "Brown",
                                        "Clark",
                                        "Fletcher",
                                        "Harris",
                                        "Johnson",
                                        "Jones",
                                        "Mardle",
                                        "Miller",
                                        "Robinson",
                                        "Smith",
                                        "Taylor",
                                        "Wallgreen",
                                        "White",
                                        "Williams",
                                        "Wilson",
                                        "Abell",
                                        "Ackworth",
                                        "Adams",
                                        "Addicock",
                                        "Alban",
                                        "Aldebourne",
                                        "Alfray",
                                        "Alicock",
                                        "Allard",
                                        "Allington",
                                        "Amberden",
                                        "Amcotts",
                                        "Amondsham",
                                        "Andrews",
                                        "Annesley",
                                        "Ansty",
                                        "Archer",
                                        "Ardall",
                                        "Ardern",
                                        "Argentein",
                                        "Arnold",
                                        "Asger",
                                        "Ashby",
                                        "Ashcombe",
                                        "Ashenhurst",
                                        "Ashton",
                                        "Askew",
                                        "Asplin",
                                        "Astley",
                                        "Atherton",
                                        "Atkinson",
                                        "Atlee",
                                        "Attilburgh",
                                        "Audeley",
                                        "Audlington",
                                        "Ayde",
                                        "Ayleward",
                                        "Aylmer",
                                        "Aynesworth",
                                        "Babham",
                                        "Babington",
                                        "Badby",
                                        "Baker",
                                        "Balam",
                                        "Baldwin",
                                        "Ballard",
                                        "Ballett",
                                        "Bammard",
                                        "Barber",
                                        "Bardolf",
                                        "Barefoot",
                                        "Barker",
                                        "Barnes",
                                        "Barre",
                                        "Barrentine",
                                        "Barrett",
                                        "Barstaple",
                                        "Bartelot",
                                        "Barton",
                                        "Basset",
                                        "Bathurst",
                                        "Battersby",
                                        "Battle",
                                        "Baynton",
                                        "Beauchamp",
                                        "Cheddar",
                                        "Chelsey",
                                        "Chernock",
                                        "Chester",
                                        "Chetwood",
                                        "Cheverell",
                                        "Cheyne",
                                        "Chichester",
                                        "Child",
                                        "Chilton",
                                        "Chowne",
                                        "Chudderley",
                                        "Church",
                                        "Churmond",
                                        "Clavell",
                                        "Claybrook",
                                        "Clement",
                                        "Clerk",
                                        "Clifford",
                                        "Clifton",
                                        "Clitherow",
                                        "Clopton",
                                        "Cobb",
                                        "Cobham",
                                        "Cobley",
                                        "Cockayne",
                                        "Cod",
                                        "Coddington",
                                        "Coffin",
                                        "Coggshall",
                                        "Colby",
                                        "Colkins",
                                        "Collard",
                                        "Colmer",
                                        "Colt",
                                        "Colthurst",
                                        "Complin",
                                        "Compton",
                                        "Conquest",
                                        "Cooke",
                                        "Coorthopp",
                                        "Coppinger",
                                        "Corbett",
                                        "Corby",
                                        "Cossington",
                                        "Cosworth",
                                        "Cotton",
                                        "Courtenay",
                                        "Covert",
                                        "Cowill",
                                        "Cox",
                                        "Crane",
                                        "Cranford",
                                        "Crawley",
                                        "Cressy",
                                        "Crickett",
                                        "Cripps",
                                        "Crisp",
                                        "Cristemas",
                                        "Crocker",
                                        "Crugg",
                                        "Cuddon",
                                        "Culpepper",
                                        "Cunningham",
                                        "Curzon",
                                        "Dagworth",
                                        "Gardiner",
                                        "Gare",
                                        "Garnis",
                                        "Garrard",
                                        "Garret",
                                        "Gascoigne",
                                        "Gasper",
                                        "Gavell",
                                        "Gedding",
                                        "Gerville",
                                        "Geste",
                                        "Gibbs",
                                        "Gifford",
                                        "Gill",
                                        "Ginter",
                                        "Gisborne",
                                        "Gittens",
                                        "Glennon",
                                        "Glover",
                                        "Gobberd",
                                        "Goddam",
                                        "Godfrey",
                                        "Gold",
                                        "Golding",
                                        "Goldwell",
                                        "Gomershall",
                                        "Gomfrey",
                                        "Gonson",
                                        "Good",
                                        "Goodenouth",
                                        "Gooder",
                                        "Goodluck",
                                        "Goodnestone",
                                        "Goodrick",
                                        "Goodrington",
                                        "Goodwin",
                                        "Goring",
                                        "Gorney",
                                        "Gorst",
                                        "Gosebourne",
                                        "Grafton",
                                        "Gray",
                                        "Greene",
                                        "Greenway",
                                        "Grenefeld",
                                        "Greville",
                                        "Grey",
                                        "Grimbald",
                                        "Grobbam",
                                        "Grofhurst",
                                        "Groston",
                                        "Grove",
                                        "Guildford",
                                        "Hackman",
                                        "Haddock",
                                        "Haddon",
                                        "Hadresham",
                                        "Hakebourne",
                                        "Hale",
                                        "Hall",
                                        "Halley",
                                        "Hambard",
                                        "Hammer",
                                        "Hammond",
                                        "Hampden"
                                      };
    }

    /**
     * Builds server configuration.
     *
     * @param builder config builder
     */
    protected ServerConfiguration(final ForgeConfigSpec.Builder builder)
    {

    }
}