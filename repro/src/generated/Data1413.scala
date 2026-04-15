package generated

final case class Data1413(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1413 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1413 = copy(value = value * k)
  def addTag(t: String): Data1413 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1413 = copy(meta = meta.updated(k, v))
  def merge(other: Data1413): Data1413 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1413 {
  given Ordering[Data1413] = Ordering.by(_.id)
  def empty: Data1413 = Data1413(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1413 =
    Data1413(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1413] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
