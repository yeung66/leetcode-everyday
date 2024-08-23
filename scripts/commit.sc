#!/usr/bin/env -S scala-cli -S 3

import java.io.File
import java.nio.file.{Files, Paths, StandardCopyOption}
import scala.sys.process._
import java.text.SimpleDateFormat
import java.util.Date

var count = 0
val PATH = "/Users/scott/codes/leetcode-everyday"
val dir = new File(PATH)
if (dir.exists && dir.isDirectory) {
  val files = dir.listFiles.filter(_.isFile).filterNot { f =>
    val name = f.getName
    name.endsWith(".idea") || name.endsWith(".gitignore") || name.endsWith(
      ".iml"
    ) || name.endsWith("DS_Store")
  }

  files.foreach { f =>
    val ext = f.getName.split('.').lastOption.getOrElse("")
    val extDir = new File(dir, ext)
    if (!extDir.exists()) {
      extDir.mkdir()
    }
    val dest = new File(extDir, f.getName)
    Files.move(f.toPath, dest.toPath, StandardCopyOption.REPLACE_EXISTING)
    count += 1
  }

  if (count == 0) {
    println("No file to commit")
    System.exit(0)
  }

  println(s"Commit $count files")

  def run(cmd: String, args: String): String = {
    val process = Process(cmd + " " + args)
    process.!!
  }

  val now = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())

  run("git", "add .")
  run("git", s"""commit -m "solve $count problem at $now"""")
  run("git", "push origin master")
} else {
  println(s"Directory $PATH does not exist or is not a directory")
  System.exit(1)
}
