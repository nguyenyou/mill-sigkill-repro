package generated

final case class Data275(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data275 = copy(name = name.toUpperCase)
  def scale(k: Double): Data275 = copy(value = value * k)
  def addTag(t: String): Data275 = copy(tags = t :: tags)
  def put(k: String, v: String): Data275 = copy(meta = meta.updated(k, v))
  def merge(other: Data275): Data275 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data275 {
  given Ordering[Data275] = Ordering.by(_.id)
  def empty: Data275 = Data275(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data275 =
    Data275(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data275] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
