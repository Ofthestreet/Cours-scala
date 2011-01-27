TOP="/CapInnovation/Scala"
FILES=Scala.html scala.css shBrushScalaInteractive.js shBrushInteractiveShell.js capgemini_logo.gif scala_logo.png capgemin_little.png
TO=ftpperso.free.fr
pushFree:
	ncftpput -u christophe.delarue1 -p $(PASS_FREE) -m $(TO) $(TOP) $(FILES)
push:
	git push https://Ofthestreet@github.com/Ofthestreet/Cours-scala.git

