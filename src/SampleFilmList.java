public class SampleFilmList {
    private String sampleList = "Mad Max: Estrada da Fúria,George Miller,Tom Hardy;Charlize Theron;" +
            "Nicholas Hoult;Hugh Keays-Byrne;Josh Helman;Nathan Jones,2015,16,2 h,8.1/10,Ação#" +
            "Senhor dos Anéis: A Sociedade do Anel,Peter Jackson,Sean Astin;Orlando Bloom;Ian McKellen;" +
            "Elijah Wood;Alan Howard,2001,12,2 h 58 min,8.8/10,Aventura#" +
            "Batman: O Cavaleiro das Trevas,Christopher Nolan,Christian Bale;Heath Ledger;Aaron Eckhart;" +
            "Michael Caine;Maggie Gyllenhaal,2008,12,2 h 32 min,9.0/10,Policial#" +
            "A Origem,Christopher Nolan,Leonardo DiCaprio;Joseph Gordon-Levitt;Elliot Page;Tom Hardy;" +
            "Ken Watanabe,2010,14,2 h 28 min,8;8/10,Ficção Científica#" +
            "Moonlight: Sob a Luz do Luar,Barry Jenkins,Mahershala Ali;Shariff Earp;Duan Sanderson;" +
            "Alex R. Hibbert;Janelle Monáe,2016,16,1 h 51 min,7.4/10,Drama#" +
            "As faces de Toni Erdmann,Maren Ade,Sandra Hüller;Peter Simonischek;Michael Wittenborn;" +
            "Thomas Loibl;Trystan Pütter,2016,16,2 h 42 min,7.3/10,Comédia#" +
            "Réquiem para um Sonho,Darren Aronofsky,Ellen Burstyn;Jared Leto;Jennifer Connelly;Marlon Wayans;" +
            "Christopher McDonald,2000,18,1 h 42 min,8.3/10,Drama#" +
            "Carlos; o Chacal,Olivier Assayas,Edgar Ramírez;Alexander Scheer;Fadi Abi Samra;Liane Sellerer;" +
            "Lamia Ahmed,2010,18,5 h 34 min,7.6/10,Biografia#" +
            "Cidade dos Sonhos,David Lynch,Naomi Watts;Jeanne Bates;Dan Birnbaum;Laura Harring;" +
            "Randall Wulff,2001,16,2 h 27 min,7;9/10,Suspense#" +
            "Amor à Flor da Pele,Kar-Wai Wong,Maggie Cheung;Tony Leung Chiu-wai;Siu Ping-Lam;Tung Cho 'Joe' Cheung;" +
            "Rebecca Pan,2000,12,1 h 38 min,8.1/10,Romance#" +
            "Lawrence da Arábia,David Lean,Peter O'Toole;Alec Guinness;Anthony Quinn;Jack Hawkins;" +
            "Omar Sharif,1962,14,3 h 38 min,8.3/10,Aventura#" +
            "Blade Runner,Ridley Scott,Harrison Ford;Sean Young;Rutger Hauer;Edward James Olmos;" +
            "M. Emmet Walsh,1982,14,1 h 57 min,8.1/10,Ação#" +
            "Apocalypse Now,Francis Ford Coppola,Marlon Brando;Martin Sheen;Robert Duvall;Frederic Forrest;" +
            "Sam Bottoms,1979,16,2h 27 min,8.4/10,Guerra#" +
            "Cidadão Kane,Orson Welles,Joseph Cotten;Dorothy Comingore;Agnes Moorehead;Ruth Warrick;" +
            "Ray Collins,1941,livre,1h 59 min,8.3/10,Mistério#" +
            "O Poderoso Chefão,Francis Ford Coppola,Marlon Brando;Al Pacino;James Caan;Richard S. Castellano;" +
            "Robert Duvall,1972,14,2h 55 min,9.2/10,Policial#" +
            "Touro Indomável,Martin Scorsese,Robert De Niro;Cathy Moriarty;Joe Pesci;Frank Vincent;" +
            "Nicholas Colasanto,1980,16,2 h 9 min,8.1/10,Biografia#" +
            "O Conformista,Bernardo Bertolucci,Jean-Louis Trintignant;Stefania Sandrelli;Gastone Moschin;" +
            "Enzo Tarascio; Fosco Giachetti,1970,R,1 h 53 min,7.9/10,Drama#" +
            "Cinzas no Paraíso,Terrence Malick,Richard Gere;Brooke Adams;Sam Shepard;Linda Manz;" +
            "Robert J. Wilke,1978,12,1 h 34 min,7.8/10,Romance#" +
            "2001 - Uma Odisseia no Espaço,Stanley Kubrick,Keir Dullea;Gary Lockwood; William Sylvester;" +
            "Daniel Richter;Leonard Rossiter,1968,Livre,2 h 29 min,8.3/10,Ficção Científica#" +
            "Operação França,William Friedkin,Gene Hackman;Fernando Rey;Roy Scheider;Tony Lo Bianco;" +
            "Marcel Bozzuffi,1971,14,1 h 44 min,7.7/10,Ação#";

    private String[] filmAll = new String[20];

    private String[][] filmByColumns = new String[20][8];

//    private String[] filmTitle = new String[20];

    private String[] filmDirector = new String[20];

    private String[][] filmArtists = new String[20][5];
    //{artista 1, artista 2, artista 3, artista 4, artista 5}

    private String[][] filmData = new String[20][6];
    //{título, ano, classificação, duração, rating, genero}

    public SampleFilmList(){
    }


    public void splitToRegister(){
        this.filmAll = this.sampleList.split("#");
    }

    public void splitToColumns(){
        String[] scratch = new String[8];

        for (int i = 0; i < this.filmAll.length; i++) {
            scratch = this.filmAll[i].split(",");
            for (int j = 0; j < 8 ; j++) {
                this.filmByColumns[i][j] = scratch[j];
            }
        }
    }

    public void buildFilmArtists(){
        String[] scratch = new String[5];

        for (int i = 0; i < this.filmByColumns.length; i++) {
            scratch = this.filmByColumns[i][2].split(";");
            for (int j = 0; j < 5 ; j++) {
                this.filmArtists[i][j] = scratch[j];
            }
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
            for (int j = 1; j < 6; j++) {
                this.filmData[i][j] = this.filmByColumns[i][j + 2];
            }
        }
    }

    public String[] getFilmAll() {
        return filmAll;
    }

    public String[][] getFilmByColumns() {
        return filmByColumns;
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

