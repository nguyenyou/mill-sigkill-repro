package generated

final case class Data1474(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1474 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1474 = copy(value = value * k)
  def addTag(t: String): Data1474 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1474 = copy(meta = meta.updated(k, v))
  def merge(other: Data1474): Data1474 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1474 {
  given Ordering[Data1474] = Ordering.by(_.id)
  def empty: Data1474 = Data1474(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1474 =
    Data1474(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1474] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
