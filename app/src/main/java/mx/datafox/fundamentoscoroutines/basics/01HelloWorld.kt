package mx.datafox.fundamentoscoroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun main() {

    /*
    Conceptos:
    Scope - Crea un ejecuta coroutines, proporciona eventos de ciclo de vida.
    Context - El ámbito provee un contexto donde se ejecuta la coroutine.
    Suspendig functions - Funciones que pueden ejecutarse en la coroutine y que  pueden suspenderse.
    Jobs - Un trabajo es un manejador de la coroutine y pueden usarse por ejemplo para cancelar la coroutine
    Deferred - El resultado de una coroutina (es resultado futuro)
    Dispatcher - Maneja en que hilo(s) se ejecuta la coroutine.
    Error handling
     */

    // Hello Coroutines

    // Para lanzar una coroutine se usa GlobalScope
    GlobalScope.launch {
        delay(2_000) // después de 2 segundos
        println("Coroutines!")  // imprime el mensaje
    }

    print("¡Hello, ")
    Thread.sleep(3_000) // para indicarle que espere 2 segundos
    // Primero imprime hola, dos segundos después imprime mundo y 1 segundo despues termina
}

/*
coroutines mitigate the complications of working with asynchronous programming. The code you write is sequential, making it easier to understand than callbacks and various observable constructs.

Threads are expensive to create and require resources to maintain. That means you can create only so many threads in a system. Opposite of that, coroutines manage their own thread pools. Some dispatchers even share pools. A suspended coroutine doesn’t block any thread and waits for the following available thread to resume.

By decoupling work and threads, it’s possible to create and execute thousands of coroutines. This is within a finite thread pool and without any overhead.

In short, a coroutine is a code component with a lifecycle that is not bound to a single thread. Any thread in the pool can execute, suspend and resume the coroutine.



Suspendable Functions
Coroutines work on the principle of suspendable functions. As you already learned, coroutines can pause and resume at any time between any number of threads. This process is code suspension.

It allows coroutines to be lightweight and fast because they don’t really allocate any overhead, such as threads. Instead, they use predefined resources and smart resource management.

The system uses continuations to know when and where to resume a function.

Continuations
When a function suspends, there is information, or state, of the suspended coroutine. Every time a coroutine suspends, it stores its state in a continuation. When the coroutine resumes, the continuation contains enough information to seamlessly continue the rest of the coroutine’s execution.

The Continuation interface consists of a CoroutineContext and a completion callback used to report the success or failure of the coroutine. In the snippet below, an existing asynchronous API service that uses callbacks is wrapped into a suspendable function that propagates the result or error using a Continuation. It’s just an example function, but the idea is there.

Coroutine Context
Coroutine context is a persistent set of data about the coroutine. It’s contained within the Continuation, making it an immutable collection of thread-local variables and program states associated with the coroutine.

Since coroutines are lightweight, it’s not a limitation that the coroutine context is immutable. If the coroutine context needs to change, you can simply launch a new coroutine with a mutated context.


 */