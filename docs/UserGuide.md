---
layout: page
title: User Guide
---

**TrAcker** is a handy contact management app built for CS Head Teaching Assistants (TAs) in NUS.
Optimized for use via a command line interface, you can manage student assignments, attendance,
tutor availability and much more with just a few keystrokes!

* Table of Contents
{:toc}

--------------------------------------------------------------------------------------------------------------------

## Quick start

1. Ensure you have Java `11` or above installed in your Computer.

2. Download the latest `TrAcker.jar` from [here](https://github.com/AY2324S2-CS2103T-T11-4/tp/releases).

3. Copy the file to the folder you want to use as the _home folder_ for your **TrAcker** app.

4. Open a command terminal, `cd` into the folder you put the jar file in, and use the `java -jar TrAcker.jar` 
   command to 
   run the application.<br>
   The GUI with some sample data should appear in a few seconds: <br>
   ![Ui](images/Ui.png)

5. Type the command in the command box and press Enter to execute it.<br>
   Some example commands you can try:
   * `list` : Lists all contacts.
   
   * `add stu /n John Doe /i A0123456Y /p 91234567 /e johndoe@example.com` : Adds the Student `John Doe` to your contact list.
   
   * `add ta /n Jane Smith /i A0654321Y /p 97654321 /e janesmith@example.com` : Adds the TA `Jane Smith` to your contact list.
   
   * `delete 3` : Deletes the 3rd contact shown in the current list.

   * `clear` : Deletes all contacts.

   * `exit` : Exits the app.

6. Refer to the [Features](#features) below for details of each command.

--------------------------------------------------------------------------------------------------------------------

## Basic Features

<div markdown="block" class="alert alert-info">

**:information_source: Notes about the command format:**<br>

* Words in `UPPER_CASE` are the parameters to be supplied by the user.<br>
  e.g. in `add stu /n NAME`, `NAME` is a parameter which can be used as `add stu /n John Doe`.

* Items with `…` after them can be used multiple times including zero times.<br>
  e.g. `[/t TAG…]` can be used as `/t friend` or `/t friend colleague` etc.

* Items in square brackets are optional.<br>
  e.g. `/n NAME [/p PHONE]` can be used as `/n John Doe /p 91234567` or as `/n John Doe`.

* Parameters can be in any order.<br>
  e.g. if the command specifies `/n NAME /i ID`, `/i ID /n NAME` is also acceptable.

* Extraneous parameters for commands that do not take in parameters (such as `help`, `list`, `exit` and `clear`) will be ignored.<br>
  e.g. if the command specifies `help 123`, it will be interpreted as `help`.

* If you are using a PDF version of this document, be careful when copying and pasting commands that span multiple lines as space characters surrounding line-breaks may be omitted when copied over to the application.
</div>

### Viewing help : `help`

Shows a message explaning how to access the help page.

![help message](images/helpMessage.png)

Format: `help`

### Adding a Student or TA: `add stu`, `add ta`

Adds a Student (TA) to the address book.

Format:
* To add a Student,<br>
  `add stu /n NAME /i ID /p PHONE /e EMAIL`

* To add a TA,<br>
  `add ta /n NAME /i ID /p PHONE /e EMAIL]`
<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
All persons are saved as either Students or TAs
</div>

Examples:
* `add stu /n Alex Yeoh /i A0777777L /p 87438807 /e alexyeoh@example.com`
* `add ta /n Charlotte Oliveiro A2222222P /p 93210283 /e charlotte@example.com`

### Listing all persons : `list`

Shows a list of all persons in TrAcker.

Format: `list`

### Editing a person : `edit`

Edits an existing person in the address book.

Format: `edit INDEX [/n NAME] [/p PHONE] [/e EMAIL]`

* Edits the person at the specified `INDEX`. The index refers to the index number shown in the displayed person list. The index **must be a positive integer** 1, 2, 3, …​
* At least one of the optional fields must be provided.
* Existing values will be updated to the input values.
* A person's `ID` cannot be edited.

Examples:
*  `edit 1 /p 91234567 /e johndoe@example.com` Edits the phone number and email address of the 1st person to be `91234567` and `johndoe@example.com` respectively.
*  `edit 2 /n Betsy Crower` Edits the name of the 2nd person to be `Betsy Crower`.

### Locating persons by name: `find`

Filters all persons whose contact details contain each of the specified keywords 
under the specified flag and displays them as a list with index numbers.

Format: `find [stu/ta] [/n NAME] [/i ID] [/p PHONE] [/e EMAIL] [/t TAGS...]`

* The search is case-insensitive. e.g. `hans` will match `Hans`
* The order of the keywords under each flag does not matter. e.g. `Hans Bo` will match `Bo Hans`
* Prefixes will be matched e.g. `Han` will match `Hans`
* For Tags:
    * For tutorial tags, prefixes will be matched
    * For other tags, it performs full word matching
    * The search filters for persons meeting ANY criteria, (i.e. `OR` search).
   
    e.g. `find /t wed assignment1` will find all persons with the tutorial tag where `wed` is a subword or have tag `assignment1`


* The search filters for persons meeting ALL criteria, (i.e. `AND` search).

  e.g. `find stu /n John` will find all Students whose names contain `John`.

Examples:
* `find /n John` returns `john` and `John Doe`
* `find ta` returns all TAs
  ![result for 'find ta'](images/findTaResult.png)

### Locating available TAs for a tutorial group: `available` 

Filters all replacement TAs who are available for a specified tutorial group.

Format: `available /g TUTORIAL`

* The search is case-sensitive and must match the specified tutorial group exactly.


Examples:
* `available /g TUES08` returns  all TAs who are available for tutorial group `TUES08`

### Deleting a person : `delete`

Deletes the specified person from the address book.

Format: `delete INDEX`

* Deletes the person at the specified `INDEX`.
* The index refers to the index number shown in the displayed person list.
* The index **must be a positive integer** 1, 2, 3, …​

Examples:
* `list` followed by `delete 2` deletes the 2nd person in the address book.
* `find Betsy` followed by `delete 1` deletes the 1st person in the results of the `find` command.

### Clearing all entries : `clear`

Clears all entries from the address book.

Format: `clear`

### Exiting the program : `exit`

Exits the program.

Format: `exit`

### Saving the data

TrAcker data is saved in the hard disk automatically after any command that changes the data. There is no need to save manually.

### Editing the data file

TrAcker data is saved automatically as a JSON file `[JAR file location]/data/addressbook.json`. Advanced users are welcome to update data directly by editing that data file.

<div markdown="span" class="alert alert-warning">:exclamation: **Caution:**
If your changes to the data file makes its format invalid, AddressBook will discard all data and start with an empty data file at the next run. Hence, it is recommended to take a backup of the file before editing it.<br>
Furthermore, certain edits can cause the AddressBook to behave in unexpected ways (e.g., if a value entered is outside of the acceptable range). Therefore, edit the data file only if you are confident that you can update it correctly.
</div>

--------------------------------------------------------------------------------------------------------------------

## Tagging

With TrAcker, you can track Student assignments, attendance, tutorial groups
(along with as TA tutorial groups and availability) using tags.

TrAcker allows use of three different types of tags : **Assignments, Attendance,** and **Tutorial** tags which can be attached to Students and TAs respectively.
The different tag types along with their corresponding tag statuses are described below.

### Tag Status

| Tag type   | Status                                                                                                                                                                                                                                                                             |
|------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Assignment | `cg` : <mark style="background-color: green">COMPLETE_GOOD</mark><br/>`cb` : <mark style="background-color: orange">COMPLETE_BAD</mark><br/>`ig` : <mark style="background-color: grey">INCOMPLETE_GOOD</mark><br/>`ib` : <mark style="background-color:red">INCOMPLETE_BAD</mark> |
| Attendance | `p` : <mark style="background-color:  green">PRESENT</mark><br/>`a` : <mark style="background-color:red">ABSENT</mark><br/>`awr` : <mark style="background-color:orange">ABSENT_WITH_REASON</mark>                                                                                 |
| Tutorial | `as` : <mark style="background-color: #3e7b91">ASSIGNED</mark><br/>`av` : <mark style="background-color: white">AVAILABLE</mark>                                                                                                                                                   |

### Marking a tag : `mark`

Updates the status of the specified tag with the specified status. If the
tag specified does not exist, a new tag with the tag name and tag status will be
created.

Format: `mark INDEX /t TAG /ts TAGSTATUS`

* The index refers to the index number shown in the displayed person list.
* The index **must be a positive integer** 1, 2, 3, …​
* `TAGSTATUS` must be one of the [above specified values](#tag-status)

Examples:
* `mark 1 /t Assignment1 /ts cg` updates the `Assignment1` tag (or adds it, if it is not already attached)
to <mark style="background-color: green">COMPLETE_GOOD</mark> for the 1st person in the displayed list.
* `mark 2 /t week1 /ts awr` updates the `week1` tag (or adds it, if it is not already attached) to
<mark style="background-color: orange">ABSENT_WITH_REASON</mark> for the 2nd person in the displayed list.
* `mark 3 /t TUE08 /ts as` updates the `TUE08` tag (or adds it, if it is not already attached) to
<mark style="background-color: #3e7b91">ASSIGNED</mark> to assign the 3rd person in the displayed list to the 
tutorial group TUE08.
* 
<div markdown="block" class="alert alert-info">

**:information_source: Note:** For **Tutorial** tags, the tutorial name must be that of a valid Tutorial tag in the list of available tutorial sessions defined with the [tuttag](#adding-a-tutorial--tuttag-add) command.
For example, in the third example above, `TUE08` should be added as a tutorial tag first using `tuttag add /t TUE08`.

</div>

### Adding a Tutorial: `tuttag add`

Creates a Tutorial tag to be used with the specified tag name.

Format: `tuttag add /t TAG`

Examples:

* `tuttag add /t TUE08` adds TUE08 as a valid Tutorial tag.

### Deleting a Tutorial: `tuttag del`

Deletes the Tutorial tag corresponding to the specified tag name. If the specified tag does not exist, no change should happen.

Format: `tuttag del /t TAG`

Examples:

* `tuttag del /t WED09` deletes WED09 as a valid Tutorial tag.

### Listing All Tutorials: `tuttag list`

Lists all Tutorial tags in TrAcker.

Format: `tuttag list`

### Removing a tag: `removetag`

Removes an individual tag from a person. If the specified tag does not exist, no change should happen.

Format: `removetag INDEX /t TAG`

* The index refers to the index number shown in the displayed person list.
* The index **must be a positive integer** 1, 2, 3, …​

Examples:
* `removetag 1 /t Assignment1` removes the `Assignment1` tag from the 1st person in the displayed list.

--------------------------------------------------------------------------------------------------------------------

## FAQ

**Q**: How do I transfer my data to another Computer?<br>
**A**: Install the app in the other computer and overwrite the empty data file it creates with the file that contains the data of your previous AddressBook home folder.

--------------------------------------------------------------------------------------------------------------------

## Known issues

1. **When using multiple screens**, if you move the application to a secondary screen, and later switch to using only the primary screen, the GUI will open off-screen. The remedy is to delete the `preferences.json` file created by the application before running the application again.

--------------------------------------------------------------------------------------------------------------------

## Command summary

Action | Format, Examples
--------|------------------
**Add** | `add TYPE /n NAME /i ID /p PHONE /e EMAIL` <br> e.g., `add stu /n Alex Yeoh /i A0777777L /p 87438807 /e alexyeoh@example.com` 
**Delete** | `delete INDEX`<br> e.g., `delete 3`
**Edit** | `edit INDEX [/n NAME] [/p PHONE] [/e EMAIL]`<br> e.g.,`edit 1 /p 91234567 /e johndoe@example.com`
**Find** | `find [stu/ta] [/n NAME] [/i ID] [/p PHONE] [/e EMAIL] [/t TAGS...]`<br> e.g., `find stu /n John`
**Available** | `available /g TUTORIAL`<br> e.g., `available /g TUES08`
**List** | `list`
**Create Valid Tutorial Tag** | `tuttag add /t TAG`<br> e.g., `tuttag add /t TUE08`
**Delete Valid Tutorial Tag** | `tuttag del /t TAG`<br> e.g., `tuttag del /t WED09`
**List Valid Tutorial Tags** | `tuttag list`
**Mark Tag** | `mark INDEX /t TAG /ts TAGSTATUS`<br> e.g., `mark 1 /t Assignment1 /ts cg`
**Remove Tag** | `removetag INDEX /t TAG`<br> e.g., `removetag 1 /t Assignment1`
**Help** | `help`
