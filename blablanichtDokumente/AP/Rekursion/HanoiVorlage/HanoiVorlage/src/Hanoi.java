class Hanoi {
    Stapel quelle, hilf, ziel;
    Scheibe[] slice;
    int anzahl;
   int k=1;
            
    public Hanoi(int n){
    	slice = new Scheibe[8];
        slice[0]=new Scheibe(28,"rot");
        slice[1]=new Scheibe(24,"blau");
        slice[2]=new Scheibe(20,"gruen");
        slice[3]=new Scheibe(16,"gelb");
        slice[4]=new Scheibe(12,"pink");
        slice[5]=new Scheibe(8,"magenta");
        slice[6]=new Scheibe(4,"lila");
        slice[7]=new Scheibe(2,"schwarz");
        anzahl=Math.min(n,slice.length); // maximal sechs Scheiben werden verschoben
        
              
        quelle=new Stapel();
        hilf=new Stapel();
        ziel=new Stapel();
        for (int i=0;i<anzahl;i++){
            quelle.einfuegen(slice[i]);
        }
    }
    
    /**
     * Verschiebt n Scheiben von einem Stapel quelle zu einem Stapel ziel und verwendet für 
     * das Verschieben den Stapel hilfe. Die Stapel besitzen jeweils die Methode einfuegen und
     * entnehmen (gibt das entnommene Element zurück).
     * Um den aktuellen Stand der Verschiebung zeichnen zu lassen, folgenden Code vewerden:
     * 
     * @param n
     * @param q
     * @param h
     * @param z
     */
    private void turmVerschieben(int n, Stapel quelle, Stapel hilfe, Stapel ziel){
    	
    	if (n > 1) {
        	turmVerschieben(n-1, quelle, ziel,hilfe);
        	
        }
        
        ziel.einfuegen(quelle.entnehmen());
        k = k + 1;
        hanoiZeichnen(100*k);
        if (n > 1) {
        	turmVerschieben(n-1, hilfe, quelle, ziel);
        }
    	
    	
    }
    
    public void hanoiturmUmstapeln(){
        datenAusgeben(); 
        hanoiZeichnen(100); // Teilaufgabe d)
        turmVerschieben(anzahl,quelle,hilf,ziel);
    }
    
    private void datenAusgeben(){
        System.out.println("----------------------------------------");
        System.out.println("Quellstapel");
        quelle.alleDatenAusgeben();
        System.out.println("Hilfsstapel");
        hilf.alleDatenAusgeben();
        System.out.println("Zielstapel");
        ziel.alleDatenAusgeben();
    }
    private void hanoiZeichnen(int ypos){
        Ausgabe a=new Ausgabe("("+k+")",400,ypos-60,200,100);      
        quelle.reiheZeichnen(100,ypos-10*quelle.anzahlScheibenGeben());
        hilf.reiheZeichnen(200,ypos-10*hilf.anzahlScheibenGeben());
        ziel.reiheZeichnen(300,ypos-10*ziel.anzahlScheibenGeben());
    }
    
    
    
 }
