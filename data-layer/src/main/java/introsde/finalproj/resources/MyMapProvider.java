/*package introsde.finalproj.resources;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

@Provider
public class MyMapProvider implements MessageBodyWriter<HashMap<String, String>>, MessageBodyReader<HashMap<String,String>>{

	public long getSize(HashMap<String, String> arg0, Class<?> arg1, Type arg2, Annotation[] arg3, MediaType arg4) {
		// TODO Auto-generated method stub
		return -1;
	}

	public boolean isWriteable(Class<?> arg0, Type arg1, Annotation[] arg2, MediaType arg3) {
		return HashMap.class.isAssignableFrom(arg0);
	}

	public void writeTo(HashMap<String, String> arg0, Class<?> arg1, Type arg2, Annotation[] arg3, MediaType arg4,
			MultivaluedMap<String, Object> arg5, OutputStream entityStream) throws IOException, WebApplicationException {

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db;
		try
		{
			db = dbf.newDocumentBuilder();
			Document doc = db.newDocument();

			Element root = doc.createElement("map");
			doc.appendChild(root);
			for (Map.Entry<String,String> element : arg0.entrySet() ) {
				Element e = doc.createElement(element.getKey());
				e.setTextContent(element.getValue());
				root.appendChild(e);
			}

			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer trans = tf.newTransformer();
			trans.transform(new DOMSource(doc), new StreamResult(entityStream));



		} catch (ParserConfigurationException e) {
			throw new WebApplicationException(e);
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public boolean isReadable(Class<?> arg0, Type arg1, Annotation[] arg2, MediaType arg3) {
		return HashMap.class.isAssignableFrom(arg0);
	}

	public HashMap<String, String> readFrom(Class<HashMap<String, String>> arg0, Type arg1, Annotation[] arg2,
			MediaType arg3, MultivaluedMap<String, String> arg4, InputStream arg5)
					throws IOException, WebApplicationException {


		try {
			HashMap<String,String> hm = new HashMap<String,String>();
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(new InputSource(arg5));

			NodeList nl = doc.getDocumentElement().getChildNodes();

			for(int c=0; c<nl.getLength(); c++){
				Node node = nl.item(c);
				if(node.getNodeType() == Node.ELEMENT_NODE){
					hm.put(node.getNodeName(), node.getTextContent());
				}
			}
			return hm;
		}
		catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}


}
*/