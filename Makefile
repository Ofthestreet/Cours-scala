TOP="/CapInnovation/Scala"
FILES=Scala.html scala.css shBrushScalaInteractive.js shBrushInteractiveShell.js capgemini_logo.gif scala_logo.png capgemin_little.png
TO=ftpperso.free.fr
push:
	ncftpput -u christophe.delarue1 -p 66689801 -m $(TO) $(TOP) $(FILES)
mv:
	mv $(FILES) Makefile Scala
