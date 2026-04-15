package generated

final case class Data1362(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1362 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1362 = copy(value = value * k)
  def addTag(t: String): Data1362 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1362 = copy(meta = meta.updated(k, v))
  def merge(other: Data1362): Data1362 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1362 {
  given Ordering[Data1362] = Ordering.by(_.id)
  def empty: Data1362 = Data1362(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1362 =
    Data1362(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1362] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
