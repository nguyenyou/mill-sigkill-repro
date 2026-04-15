package generated

final case class Data666(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data666 = copy(name = name.toUpperCase)
  def scale(k: Double): Data666 = copy(value = value * k)
  def addTag(t: String): Data666 = copy(tags = t :: tags)
  def put(k: String, v: String): Data666 = copy(meta = meta.updated(k, v))
  def merge(other: Data666): Data666 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data666 {
  given Ordering[Data666] = Ordering.by(_.id)
  def empty: Data666 = Data666(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data666 =
    Data666(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data666] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
