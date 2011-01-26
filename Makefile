TOP="/CapInnovation/Scala"
FILES=Scala.html scala.css shBrushScalaInteractive.js shBrushInteractiveShell.js capgemini_logo.gif scala_logo.png capgemin_little.png
TO=ftpperso.free.fr
push:
	git push https://Ofthestreet@github.com/Ofthestreet/Cours-scala.git
	#ncftpput -u christophe.delarue1 -p xxx -m $(TO) $(TOP) $(FILES)
