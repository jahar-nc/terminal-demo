# What is the terminal

A beginners guide to the terminal.

Like `cmd.exe`, the terminal is where you can type commands into
a prompt and then have them executed. A terminal is more fully featured than
`cmd.exe`. Easily allowing you to link commands together and offering tab completion.

The shell is what the terminal uses to read commands and go and execute them. It is
turing complete. Indeed many scripts are written that solely use the shell.
There are many different shells, but typically the default is `bash` (Bourne again shell).
This doesn't mean it's the best shell out there, just the most common.

# Filesystem Hierarchy (Standard)

Predefines where given types of files should exist.

The root is `/`. This is broadly comparable to `C:\`.
`/bin` is where most executables and programs live.
`/home` contains each user's personal directory. Except
for the admin user (`root`), which uses `/root`. `~` can be
used as shorthand for the home directory of the current user.
`/` is used to separate directory and filenames. eg. `/foo/bar/baz.txt`.
`.` is a special directory name, meaning the current directory. eg.
if you are in `/foo/bar`, then `.` means `/foo/bar`. `..` is another
special directory name, meaning the parent directory of the current
directory. If you are in `/foo/bar` then `..` means `/foo`. `/foo/bar/../baz`
is evalutated to mean `/foo/baz`.

Paths begining with `/` are unambiguous and know as absolute paths. Paths
starting with any other character could refer to different files depending
on the directory you are currently. They are known as relative paths.

## The root user and permissions

The root user is completely unrestricted and can do anything.
Executing `rm -rf /` as root will destroy your system and
make it unusable.

You should typically never be directly using a shell as the root user.
Rather, you should use commands like `sudo` than can temporarily elevate
privileges to run a command as the root user.

# Navigation

Commands for moving around the filesystem and seeing what exists.

* ls -- List the contents of a directory/folder
* cd -- Change the Directory you are currently in
	`cd -` allows you to switch back the previous directory you were in
* pwd -- Prints the (Working) Directory you are currently in.

# File Manipulation

Commands for navigating your machine and modifying the filesystems

* mv -- MoVe a file or directory, or rename a file or directory
* cp -- CoPy a file or directory to another location
* rm -- ReMove a file or directory from the filesystem
	NB. Be careful! `rm` completely removes the file and skips the recycle bin
* mkdir -- MaKe DIRectory, used to create new directories
* rmdir -- ReMove DIRectory, used to remove empty directories

# Examining and editing files

* less -- Read and search through files or program output. (how to search with `/`)
* nano/vim/emacs -- Command line tools for editing files (recommend getting familar with `vim`)
* grep -- prints lines of a file that match a pattern or regular expression
* cat -- prints out the contents of one or more files to the terminal
* tail -- prints out the last N lines of a file

# Checking and manipulating processes

* ps -- Process Status, see what processes are running
* top -- realtime updates of currently running processes (`q` to quit)
* kill -- Stop other processes, forcibly if they are misbehaving
* Ctrl-C vs Ctrl-D vs Ctrl-Z (plus fg and bg)
	* Ctrl-C -- send a signal to a foreground process in the terminal, politely
	asking it to stop
	* Ctrl-Z -- send a signal to the terminal asking it to suspend the current
	foreground process
		* bg -- let a suspended process continue running in the BackGround
		* fg -- let a suspended process continue running in the ForeGround
	* Ctrl-D -- Close the standard input of a process. This will cause many
	processes to finish what they are doing and exit. If you have no currently
	running process then you close the input of your shell process which means
	it will exit

# Variables

* check the value of a variable
* uppercase used to denote environment variables
* how to set and unset variables
* how to make variables available to subprocesses (export)
* Special variables eg. `$?` -- did the last program exit happily or not
* list all environment variables `env`

## Check the value of a variable:

`$` means that next bit of text is a variable, and not literal text.

`echo` is a program that prints to the terminal its arguments.

```shell
echo $USER
# or
echo ${USER} # braces delinate what is the name of the variable
# eg. compare:
echo ${USER}1
# vs
echo $USER1
```

## Setting variables:

```shell
foo=bar  # no spaces around the `=` sign
echo $foo
```

Quoting can ensure spaces in variables are preserved. eg

```shell
foo="bar baz"  # NB. " is not part of the variable contents
cat > script.py << EOF
import sys
print('got', len(sys.argv), 'args')
print('args are:', sys.argv)
EOF
python3 script.py $foo # two separate args!
python3 script.py "$foo" # preserve spaces in single arg
```

Use `export` to make your variables available to child processes

compare eg.
```shell
# NB. brackets "()" creates a child shell to execute commands in
foo=bar
( env | grep foo )
# vs
export foo=bar
( env | grep foo )
```

## Variable names

Variables names typically must start with a letter of the alphabet, or an underscore.
After that may also contain digits eg. `arg1` or `USER2`.

There are some special variables that start with punctuation or numbers. The most
relevant of this is `$?`, which is used to query the exit code of the last command
you executed. `0` means the program ran succesfully. Any other number means there
was a problem. What this number means will be documented in the command's help or manual.

# Installing new software

* apt vs yum (debian vs red hat)

# Pipes and redirection

Programs can be linked together to create pipelines. This can be means you can create
quite complex commans from simple building blocks. For instance, the following pipeline
finds all the java files under the current directory prints out filenames and lines
that contain Foo, foo or bar. This is paged using `less`, just in case lots of output is
created.

```shell
find . -name '*.java' | xargs grep -E '[Ff]oo|bar' --color=yes | less -R
```

You can also redirect any output that might be printed to the terminal to instead be
saved into a file. This is done using `>` and `>>`. The first clears the file beforehand, and the second appends instead. eg.

```shell
echo this is the first line > my_file.txt
echo the second line >> my_file.txt
```

Creating pipelines with `|` runs all the commands regardless of what happens. Sometimes,
you only want to run a second command if the first command is successful. As a very basic
example:

```shell
# test that the file exists, then compile it, then run the resulting class file
ls foo/Main.java && javac foo/Main.java && java.foo.Main
```

# Getting help

`man` can be used to get help on a given command. It uses `less` to provide this information
in the terminal. For example `man ls`. To navigate use PgUp, PgDown and the arrow keys. To exit press `q`.
If that doesn't work, press Esc a few times and then press `q`.

# Useful Links

* https://digitalocean.com/community/tutorials/an-introduction-to-linux-basics

