import javax.xml.parsers.DocumentBuilderFactory
import java.io.StringReader
import javax.xml.xpath.{XPathFactory, XPathConstants}
import org.w3c.dom.{Node, NodeList, Document}
import org.xml.sax.InputSource
/**
 * The purpose of this facade class is to provide a simplified API to the core Java classes/interfaces
 * with a public method that can return a NodeList with nodes that matches a specified
 * XPath expression in an XML structure provided as a String.
 *
 * While the singleton instance (defined as 'object' instead of 'class') is written in Scala,
 * it is using lots of Java classes/interfaces in the implementation, as you can see
 * in the above list of imports. 
 */
object XmlFacade {

  /**
   * This is the public facade method (and please note that the default access level in Scala is public)
   * and the other methods further below are only private helper methods.
   */
  def getNodeListMatchingXPathExpression(xml: String , xPathExpression: String) : NodeList = {
    val document = getInputSourceAsDocument(getXmlStringAsInputSource(xml))
    // The type is above inferred automatically but could optionally has been defined explicitly as below:
    //val document: org.w3c.dom.Document = getInputSourceAsDocument(getXmlStringAsInputSource(xml))
    getNodeListMatchingXPathExpression(document, xPathExpression)
  }

  private val xPath = XPathFactory.newInstance().newXPath()

  private def getNodeListMatchingXPathExpression(
    node: Node,
    xPathExpressionAsString: String // "AsString"-suffix purpose: a local variable will be a 'org.w3c.dom.xpath.XPathExpression'
  ) : NodeList = {
    val xPathExpression = xPath.compile(xPathExpressionAsString)
    val nodesFoundByXPathExpression = xPathExpression.evaluate(node, XPathConstants.NODESET)
    // the above returned type is Object (as declared in method signature of method 'evaluate')
    // but the concrete type will be 'org.w3c.dom.NodeList' (defined by parameter 'XPathConstants.NODESET')
    // so therefore we below will cast the Object to a NodeList when returning it
    nodesFoundByXPathExpression.asInstanceOf[NodeList]
  }

  private val documentBuilderFactory = DocumentBuilderFactory.newInstance()
  documentBuilderFactory.setNamespaceAware(true)
  private val documentBuilder = documentBuilderFactory.newDocumentBuilder()

  private def getInputSourceAsDocument(xmlInputSource: InputSource) : Document = {
    documentBuilder.parse(xmlInputSource)
  }

  private def getXmlStringAsInputSource(xmlString: String): InputSource = {
    val reader = new StringReader(xmlString);
    new InputSource(reader);
  }
}
