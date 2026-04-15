package generated

final case class Data1321(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1321 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1321 = copy(value = value * k)
  def addTag(t: String): Data1321 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1321 = copy(meta = meta.updated(k, v))
  def merge(other: Data1321): Data1321 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1321 {
  given Ordering[Data1321] = Ordering.by(_.id)
  def empty: Data1321 = Data1321(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1321 =
    Data1321(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1321] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
