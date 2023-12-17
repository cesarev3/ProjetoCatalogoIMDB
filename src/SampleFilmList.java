public class SampleFilmList {

    private String[] filmAll = new String[20];

    private final String[][] filmByColumns = new String[20][8];

//    private String[] filmTitle = new String[20];

    private final String[] filmDirector = new String[20];

    private final String[][] filmArtists = new String[20][5];
    //{artista 1, artista 2, artista 3, artista 4, artista 5}

    private final String[][] filmData = new String[20][6];
    //{título, ano, classificação, duração, rating, genero}

    public SampleFilmList(){
    }


    public void splitToRegister(){
        String sampleList = "Mad Max: Estrada da Fúria,George Miller,Tom Hardy;Charlize Theron;" +
                "Nicholas Hoult;Hugh Keays-Byrne;Josh Helman;Nathan Jones,2015,16,2h,8.1/10,Ação#" +
                "Senhor dos Anéis: A Sociedade do Anel,Peter Jackson,Sean Astin;Orlando Bloom;Ian McKellen;" +
                "Elijah Wood;Alan Howard,2001,12,2h 58min,8.8/10,Aventura#" +
                "Batman: O Cavaleiro das Trevas,Christopher Nolan,Christian Bale;Heath Ledger;Aaron Eckhart;" +
                "Michael Caine;Maggie Gyllenhaal,2008,12,2h 32min,9.0/10,Policial#" +
                "A Origem,Christopher Nolan,Leonardo DiCaprio;Joseph Gordon-Levitt;Elliot Page;Tom Hardy;" +
                "Ken Watanabe,2010,14,2h 28min,8.8/10,Ficção Científica#" +
                "Moonlight: Sob a Luz do Luar,Barry Jenkins,Mahershala Ali;Shariff Earp;Duan Sanderson;" +
                "Alex R. Hibbert;Janelle Monáe,2016,16,1h 51min,7.4/10,Drama#" +
                "As faces de Toni Erdmann,Maren Ade,Sandra Hüller;Peter Simonischek;Michael Wittenborn;" +
                "Thomas Loibl;Trystan Pütter,2016,16,2h 42min,7.3/10,Comédia#" +
                "Réquiem para um Sonho,Darren Aronofsky,Ellen Burstyn;Jared Leto;Jennifer Connelly;Marlon Wayans;" +
                "Christopher McDonald,2000,18,1h 42min,8.3/10,Drama#" +
                "Carlos; o Chacal,Olivier Assayas,Edgar Ramírez;Alexander Scheer;Fadi Abi Samra;Liane Sellerer;" +
                "Lamia Ahmed,2010,18,5h 34min,7.6/10,Biografia#" +
                "Cidade dos Sonhos,David Lynch,Naomi Watts;Jeanne Bates;Dan Birnbaum;Laura Harring;" +
                "Randall Wulff,2001,16,2h 27min,7.9/10,Suspense#" +
                "Amor à Flor da Pele,Kar-Wai Wong,Maggie Cheung;Tony Leung Chiu-wai;Siu Ping-Lam;Tung Cho 'Joe' Cheung;" +
                "Rebecca Pan,2000,12,1h 38min,8.1/10,Romance#" +
                "Lawrence da Arábia,David Lean,Peter O'Toole;Alec Guinness;Anthony Quinn;Jack Hawkins;" +
                "Omar Sharif,1962,14,3h 38min,8.3/10,Aventura#" +
                "Blade Runner,Ridley Scott,Harrison Ford;Sean Young;Rutger Hauer;Edward James Olmos;" +
                "M. Emmet Walsh,1982,14,1h 57min,8.1/10,Ação#" +
                "Apocalypse Now,Francis Ford Coppola,Marlon Brando;Martin Sheen;Robert Duvall;Frederic Forrest;" +
                "Sam Bottoms,1979,16,2h 27min,8.4/10,Guerra#" +
                "Cidadão Kane,Orson Welles,Joseph Cotten;Dorothy Comingore;Agnes Moorehead;Ruth Warrick;" +
                "Ray Collins,1941,livre,1h 59min,8.3/10,Mistério#" +
                "O Poderoso Chefão,Francis Ford Coppola,Marlon Brando;Al Pacino;James Caan;Richard S. Castellano;" +
                "Robert Duvall,1972,14,2h 55min,9.2/10,Policial#" +
                "Touro Indomável,Martin Scorsese,Robert De Niro;Cathy Moriarty;Joe Pesci;Frank Vincent;" +
                "Nicholas Colasanto,1980,16,2h 9min,8.1/10,Biografia#" +
                "O Conformista,Bernardo Bertolucci,Jean-Louis Trintignant;Stefania Sandrelli;Gastone Moschin;" +
                "Enzo Tarascio; Fosco Giachetti,1970,R,1h 53min,7.9/10,Drama#" +
                "Cinzas no Paraíso,Terrence Malick,Richard Gere;Brooke Adams;Sam Shepard;Linda Manz;" +
                "Robert J. Wilke,1978,12,1h 34min,7.8/10,Romance#" +
                "2001 - Uma Odisseia no Espaço,Stanley Kubrick,Keir Dullea;Gary Lockwood; William Sylvester;" +
                "Daniel Richter;Leonard Rossiter,1968,Livre,2h 29min,8.3/10,Ficção Científica#" +
                "Operação França,William Friedkin,Gene Hackman;Fernando Rey;Roy Scheider;Tony Lo Bianco;" +
                "Marcel Bozzuffi,1971,14,1h 44min,7.7/10,Ação#";
        this.filmAll = sampleList.split("#");
    }

    public void splitToColumns(){
        String[] scratch;
        for (int i = 0; i < this.filmAll.length; i++) {
            scratch = this.filmAll[i].split(",");
            System.arraycopy(scratch, 0, this.filmByColumns[i], 0, 8);
        }
    }

    public void buildFilmArtists(){
        String[] scratch;
        for (int i = 0; i < this.filmByColumns.length; i++) {
            scratch = this.filmByColumns[i][2].split(";");
            System.arraycopy(scratch, 0, this.filmArtists[i], 0, 5);
        }
    }

    public void buildFilmTitle(){
        for (int i = 0; i < this.filmByColumns.length; i++) {
            this.filmData[i][0] = this.filmByColumns[i][0];
        }
    }

    public void buildFilmDirector(){
        for (int i = 0; i < this.filmByColumns.length; i++) {
            this.filmDirector[i] = this.filmByColumns[i][1];
        }
    }

    public void buildFilmData(){
        for (int i = 0; i < this.filmByColumns.length; i++) {
            System.arraycopy(this.filmByColumns[i], 3, this.filmData[i], 1, 5);
        }
    }

    public String[] getFilmDirector() {
        return filmDirector;
    }

    public String[][] getFilmArtists() {
        return filmArtists;
    }

    public String[][] getFilmData() {
        return filmData;
    }
}

