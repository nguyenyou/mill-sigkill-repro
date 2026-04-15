package generated

final case class Data1380(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1380 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1380 = copy(value = value * k)
  def addTag(t: String): Data1380 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1380 = copy(meta = meta.updated(k, v))
  def merge(other: Data1380): Data1380 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1380 {
  given Ordering[Data1380] = Ordering.by(_.id)
  def empty: Data1380 = Data1380(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1380 =
    Data1380(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1380] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
