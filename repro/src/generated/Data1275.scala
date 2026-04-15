package generated

final case class Data1275(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1275 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1275 = copy(value = value * k)
  def addTag(t: String): Data1275 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1275 = copy(meta = meta.updated(k, v))
  def merge(other: Data1275): Data1275 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1275 {
  given Ordering[Data1275] = Ordering.by(_.id)
  def empty: Data1275 = Data1275(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1275 =
    Data1275(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1275] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
