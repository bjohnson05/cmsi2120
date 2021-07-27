/*
 * filename: IntLinkedList.java
 * purpose: demonstrates a singly linked list data structure
 */

   public class IntLinkedList {

      private Node head;
      private int  size;

     // the constructor
      IntLinkedList() {
         head = null;
         size = 0;
      }

     // get the count of items in the list
      public int getSize() {
         return size;
      }

     // add a node to the head of the list
      public void prepend( int dataToAdd ) {
         Node currentHead = head;
         head = new Node( dataToAdd );
         head.next = currentHead;
         size++;
      }

     // get an iterator whose "currentNode" is set to the node
     //  at a specific index; note: zero means the head of the list
      public Iterator getIteratorAt( int index ) {
         if( (index > size) || (index < 0) ) {
            throw new IllegalArgumentException( "  In getIteratorAt() ~ index out of range" );
         }
         Iterator it = new Iterator();
         while( index > 0 ) {
            it.next();
            index--;
         }
         return it;
      }

/**
 *  insertAt() takes an integer index location and a data value and
 *    inserts a node with that data BEFORE the node at that index.
 */
      public void insertAt( int index, int dataValue ) {
         Iterator thisIsIt = getIteratorAt( index - 1 );
         Node newNode = new Node( dataValue );
         newNode.next = thisIsIt.currentNode.next;
         thisIsIt.currentNode.next = newNode;
         size++;
      }

/**
 *  removeAt() takes an integer index location ONLY, and removes the
 *    node at that index.
 */
      public int removeAt( int index ) {
         Iterator notIt = getIteratorAt( index - 1 );
         int valueRemoved = notIt.currentNode.next.data;
         notIt.currentNode.next = notIt.currentNode.next.next;
         size--;
         return valueRemoved;
      }

/**
 * The internal Node class; each node has a data field that
 *    stores an int, and a Node field that stores a reference
 *    to the next node in the list
 */
      private class Node {

         int data;            // remember this is an IntLinkedList
         Node next;           // here's the self-referential part

         // constructor
         Node( int d ) {
            data = d;
            next = null;
         }
      }

/**
 * The internal Iterator class; this provides the ability to
 *    go through all the nodes in the list, starting at any
 *    node you choose, and also allows visibility at the
 *    list item that is currently being referred to
 */
      public class Iterator {
         private Node currentNode;

        // constructor
         Iterator() {
            currentNode = head;
         }

        // point current node at the next node in the list
         public void next() {
            if( currentNode == null ) {
               return;
            } else {
               currentNode = currentNode.next;
            }
         }

        // check if there is another node AFTER the current node
         public boolean hasNext() {
            return ((currentNode != null) && (currentNode.next != null));
         }

        // return the DATA VALUE of the current node
         public int getCurrentInt() {
            return currentNode.data;
         }

      }
   }
