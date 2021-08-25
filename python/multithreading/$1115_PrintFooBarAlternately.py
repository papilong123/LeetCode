from threading import Lock


class FooBar:
    def __init__(self, n):
        self.n = n
        self.FooLock = Lock()
        self.BarLock = Lock()
        self.BarLock.acquire()

    def foo(self, printFoo: 'Callable[[], None]') -> None:

        for i in range(self.n):
            self.FooLock.acquire()
            # printFoo() outputs "foo". Do not change or remove this line.
            printFoo()
            self.BarLock.release()

    def bar(self, printBar: 'Callable[[], None]') -> None:

        for i in range(self.n):
            self.BarLock.acquire()
            # printBar() outputs "bar". Do not change or remove this line.
            printBar()
            self.FooLock.release()
