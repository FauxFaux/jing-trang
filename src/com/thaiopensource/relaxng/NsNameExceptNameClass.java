package com.thaiopensource.relaxng;

class NsNameExceptNameClass implements NameClass {

  private final NameClass nameClass;
  private final String namespaceURI;

  NsNameExceptNameClass(String namespaceURI, NameClass nameClass) {
    this.namespaceURI = namespaceURI;
    this.nameClass = nameClass;
  }

  public boolean contains(Name name) {
    return (this.namespaceURI.equals(name.getNamespaceUri())
	    && !nameClass.contains(name));
  }

  public boolean equals(Object obj) {
    if (obj == null || !(obj instanceof NsNameExceptNameClass))
      return false;
    NsNameExceptNameClass other = (NsNameExceptNameClass)obj;
    return (namespaceURI.equals(other.namespaceURI)
	    && nameClass.equals(other.nameClass));
  }

  public int hashCode() {
    return namespaceURI.hashCode() ^ nameClass.hashCode();
  }

  public void accept(NameClassVisitor visitor) {
    visitor.visitNsNameExcept(namespaceURI, nameClass);
  }

  public boolean isOpen() {
    return true;
  }
}

