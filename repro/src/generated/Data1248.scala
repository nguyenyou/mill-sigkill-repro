package generated

final case class Data1248(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1248 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1248 = copy(value = value * k)
  def addTag(t: String): Data1248 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1248 = copy(meta = meta.updated(k, v))
  def merge(other: Data1248): Data1248 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1248 {
  given Ordering[Data1248] = Ordering.by(_.id)
  def empty: Data1248 = Data1248(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1248 =
    Data1248(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1248] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
