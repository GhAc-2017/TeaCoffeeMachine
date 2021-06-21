package core.operations.tasks

import java.util.concurrent.RejectedExecutionHandler
import java.util.concurrent.ThreadPoolExecutor

internal class TaskRejectionHandler : RejectedExecutionHandler {
    override fun rejectedExecution(r: Runnable, executor: ThreadPoolExecutor) {
        println(
            "TaskRejectionHandler: The beverage request $r has been rejected by coffee machine"
        )
    }
}