package generated

final case class Data838(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data838 = copy(name = name.toUpperCase)
  def scale(k: Double): Data838 = copy(value = value * k)
  def addTag(t: String): Data838 = copy(tags = t :: tags)
  def put(k: String, v: String): Data838 = copy(meta = meta.updated(k, v))
  def merge(other: Data838): Data838 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data838 {
  given Ordering[Data838] = Ordering.by(_.id)
  def empty: Data838 = Data838(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data838 =
    Data838(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data838] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
