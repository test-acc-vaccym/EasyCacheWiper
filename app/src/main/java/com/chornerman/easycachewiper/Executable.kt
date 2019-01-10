package com.chornerman.easycachewiper

import java.io.*
import java.lang.NullPointerException
import java.lang.StringBuilder

interface Executable {

    fun execute(command: String): String {
        val process = Runtime.getRuntime().exec("su")
        val dataOutputStream = DataOutputStream(process.outputStream)
        dataOutputStream.writeBytes("$command 2>&1\nexit\n")
        dataOutputStream.flush()
        dataOutputStream.close()

        val output = StringBuilder()
        val processReader = BufferedReader(InputStreamReader(process.inputStream))
        try {
            for (line in processReader.readLine())
                output.append(line)
        } catch (exception: NullPointerException) {
            return ""
        }
        return output.toString()
    }
}