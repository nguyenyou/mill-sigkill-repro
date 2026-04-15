package generated

final case class Data534(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data534 = copy(name = name.toUpperCase)
  def scale(k: Double): Data534 = copy(value = value * k)
  def addTag(t: String): Data534 = copy(tags = t :: tags)
  def put(k: String, v: String): Data534 = copy(meta = meta.updated(k, v))
  def merge(other: Data534): Data534 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data534 {
  given Ordering[Data534] = Ordering.by(_.id)
  def empty: Data534 = Data534(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data534 =
    Data534(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data534] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
