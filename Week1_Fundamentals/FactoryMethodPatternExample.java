package Week1_Fundamentals;
interface WordDocument
{
    abstract void displayword();
}
 abstract class PdfDocument
 {
    abstract void displaypdf();
 }
 abstract class DocumentFactory
 {
    abstract public void createDocument();
 }
 interface ExcelDocument
 {
    abstract void displayexcel();
 }
 class Word implements WordDocument
 {
    public void displayword()
    {
        System.out.println("displaying word document");
    }
 } class Pdf extends PdfDocument
 {
    public void displaypdf()
    {
        System.out.println("displaying pdf document");
    }
 } class Excel implements ExcelDocument
 {
    public void displayexcel()
    {
        System.out.println("displaying excel document");
    }
 }

 class Factory extends DocumentFactory
 {
    public static Factory createDocument(String type)
    {
        if(type.equalsIgnoreCase("word"))
        {
            return new Word();
        }
    }
 }  