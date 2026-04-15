package generated

final case class Data1099(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1099 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1099 = copy(value = value * k)
  def addTag(t: String): Data1099 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1099 = copy(meta = meta.updated(k, v))
  def merge(other: Data1099): Data1099 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1099 {
  given Ordering[Data1099] = Ordering.by(_.id)
  def empty: Data1099 = Data1099(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1099 =
    Data1099(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1099] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
