package cn.com.java.mode.facade;

public class Facade {
    private FileReader reader;
    private FileWriter writer;
    private CipherMachine cipherMachine;

    public Facade(FileReader reader, FileWriter writer, CipherMachine cipherMachine) {
        this.reader = reader;
        this.writer = writer;
        this.cipherMachine = cipherMachine;
    }

    public FileReader getReader() {
        return reader;
    }

    public void setReader(FileReader reader) {
        this.reader = reader;
    }

    public FileWriter getWriter() {
        return writer;
    }

    public void setWriter(FileWriter writer) {
        this.writer = writer;
    }

    public CipherMachine getCipherMachine() {
        return cipherMachine;
    }

    public void setCipherMachine(CipherMachine cipherMachine) {
        this.cipherMachine = cipherMachine;
    }

    public String cipher(String fileName){
        String read = this.reader.read(fileName);
        String doFinal = this.cipherMachine.doFinal(read);
        return this.writer.write(doFinal);
    }
}
