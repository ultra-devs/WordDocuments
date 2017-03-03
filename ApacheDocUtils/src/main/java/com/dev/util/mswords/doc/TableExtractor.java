package com.dev.util.mswords.doc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.aspose.words.Document;
import com.aspose.words.Node;
import com.aspose.words.NodeType;
import com.aspose.words.Paragraph;
import com.aspose.words.Table;

public class TableExtractor {
	@SuppressWarnings("unchecked")
	static List<Node> tables = new ArrayList<Node>();

	public static void main(String[] args) throws Exception {
		Document doc = new Document("E:/2017/poc/testdata/ws_datapedia/NAME.doc");

		// Create a clone of the document
		Document tempDoc = doc.deepClone();
		for (int j = 0; j < doc.getPageCount(); j++) {

			tables = Arrays.asList(tempDoc.getChildNodes(NodeType.TABLE, true).toArray());
			System.out.println(tables.size() + "-------------");
		}
		// Clear tempDoc
		tempDoc.getSections().clear();
		tempDoc.ensureMinimum();

		for (int i = 0; i < tables.size(); i++) {
			Table docTable = (Table) tables.get(i);
			Table docTableCopy = (Table) docTable.deepClone(true);

			// Insert table into document
			tempDoc.getFirstSection().getBody().insertAfter(docTableCopy,
					tempDoc.getFirstSection().getBody().getFirstParagraph());

			// Insert paragraph between tables
			tempDoc.getFirstSection().getBody().insertAfter(new Paragraph(tempDoc),
					tempDoc.getFirstSection().getBody().getFirstParagraph());
		}

		tempDoc.save("E:/2017/poc/testdata/ws_datapedia/outTables.html");

	}
}
