package collection_and_map.Collection.list;

import java.util.LinkedList;

/**
 *
 * linkedlist 源码分析
 *
 * linkedlist是一个双向链表  内部节点
 * add就是正常双向链表操作
 *   private static class Node<E> {
 *         E item;
 *         Node<E> next;
 *         Node<E> prev;
 *
 *         Node(Node<E> prev, E element, Node<E> next) {
 *             this.item = element;
 *             this.next = next;
 *             this.prev = prev;
 *         }
 *     }
 *
 * @author cky
 * @create 2020  2 17 12:07
 */
public class linkedkist {
    public static void main(String[] args) {
        LinkedList list=new LinkedList();
        list.add(10);
    }
}
