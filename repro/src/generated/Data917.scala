package generated

final case class Data917(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data917 = copy(name = name.toUpperCase)
  def scale(k: Double): Data917 = copy(value = value * k)
  def addTag(t: String): Data917 = copy(tags = t :: tags)
  def put(k: String, v: String): Data917 = copy(meta = meta.updated(k, v))
  def merge(other: Data917): Data917 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data917 {
  given Ordering[Data917] = Ordering.by(_.id)
  def empty: Data917 = Data917(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data917 =
    Data917(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data917] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
