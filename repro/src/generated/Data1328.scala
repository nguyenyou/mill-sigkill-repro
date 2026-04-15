package generated

final case class Data1328(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1328 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1328 = copy(value = value * k)
  def addTag(t: String): Data1328 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1328 = copy(meta = meta.updated(k, v))
  def merge(other: Data1328): Data1328 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1328 {
  given Ordering[Data1328] = Ordering.by(_.id)
  def empty: Data1328 = Data1328(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1328 =
    Data1328(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1328] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
