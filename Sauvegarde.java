import java.io.*;

public class Sauvegarde implements Serializable {
    
    public static void sauvegarde(Dresseur dresseur) throws IOException{
        
        FileOutputStream fileOutputStream = new FileOutputStream("sauvegarde.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(dresseur);
        objectOutputStream.flush();
        objectOutputStream.close();
    }

    public static Dresseur loadSauvegarde() throws ClassNotFoundException, IOException{
        FileInputStream fileInputStream = new FileInputStream("sauvegarde.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Dresseur dresseur = (Dresseur) objectInputStream.readObject();
        objectInputStream.close(); 
        return dresseur;
    }
}
