package com.qy105.aaa.filter

import com.netflix.zuul.ZuulFilter
import com.netflix.zuul.context.RequestContext
import com.netflix.zuul.exception.ZuulException
import org.springframework.stereotype.Component

import javax.servlet.http.HttpServletRequest
import java.io.IOException

@Component
class CustomZuulFilter : ZuulFilter() {
    override fun filterType(): String {
        return "pre"
    }

    override fun filterOrder(): Int {
        return 0
    }

    override fun shouldFilter(): Boolean {
        return true
    }

    @Throws(ZuulException::class)
    override fun run(): Any? {
        val currentContext = RequestContext.getCurrentContext()
        val request = currentContext.request
        val id = request.getParameter("id")
        if (id == null) {
            //过滤该请求
            currentContext.setSendZuulResponse(false)
            currentContext.responseStatusCode = 401
            try {
                currentContext.response.writer.write("this id is null")
            } catch (e: IOException) {
                e.printStackTrace()
            }

        } else {
            currentContext.setSendZuulResponse(true)
            currentContext.responseStatusCode = 200
            currentContext.set("isSuccess", true)
        }

        return null
    }
}

