package mediatheque;

import java.util.LinkedList;
import java.util.List;


public class Mediatheque {
	private List<Item> items = new LinkedList<Item>();

	public static void main(String[] args) {
		Mediatheque mediatheque = new Mediatheque();
		
		mediatheque.addItem( new Book("J.R.R. Tolkien", "Le seigneur des anneaux"));
		mediatheque.addItem( new Book("Philip K. Dick", "Le Maître du haut chateau"));
                mediatheque.addItem( new Book("Bernard Werber", "Les Fourmis"));
		mediatheque.addItem( new CD(12, "Sergeant Peppers"));
                mediatheque.addItem( new CD(1, "Harry Potter à l'école des sorciers"));
		mediatheque.printCatalog();
		mediatheque.printOnlyBooks();
		mediatheque.printOnlyCDs();		
	}
	
	public void addItem(Item i) {
		items.add(i);
	}
	
	public void printCatalog() {
		for (Item i : items)
			System.out.println(i);
	}
	
	public void printOnlyBooks() {
		accept( 
			
			new ItemPrinter() {
				@Override
				public void visit(CD cd) {  }
			} 
		);
	}

	public void printOnlyCDs() {
		accept( 			
			new ItemPrinter() {
				@Override
				public void visit(Book b) { }
			} 
		); 
	}
        
        private void accept(ItemVisitor v) {
		for (Item i : items)
			i.accept(v);
	}

}
