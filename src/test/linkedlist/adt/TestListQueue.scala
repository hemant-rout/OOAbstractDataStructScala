package test.linkedlist.adt

import org.junit._
import org.junit.Assert._
import linkedlist.adt.ListQueue
import linkedlist.adt.Queue

class TestListQueue {
  var queue: Queue[Int] = null

  @Before def initStack {
    queue = new ListQueue[Int]
  }

  @Test def emptyOnCreate {
    assertTrue(queue.isEmpty)
  }

  @Test def nonEmptyOnEnqueue {
    queue.enqueue(5)
    assertFalse(queue.isEmpty)
  }

  @Test def enqueueDequeue {
    queue.enqueue(5)
    assertEquals(5, queue.dequeue)
  }

  @Test def enqueueDequeueEnqueueDequeue {
    queue.enqueue(5)
    assertEquals(5, queue.dequeue)
    queue.enqueue(3)
    assertEquals(3, queue.dequeue)
  }

  @Test def enqueueEnqueueDequeueDequeue {
    queue.enqueue(5)
    queue.enqueue(3)
    assertEquals(5, queue.dequeue)
    assertEquals(3, queue.dequeue)
  }

  @Test def enqueue100Dequeue100 {
    val nums = Array.fill(100)(util.Random.nextInt)
    nums.foreach(queue.enqueue(_))
    nums.foreach(assertEquals(_, queue.dequeue))
  }
}