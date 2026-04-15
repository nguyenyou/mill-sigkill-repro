package generated

final case class Data755(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data755 = copy(name = name.toUpperCase)
  def scale(k: Double): Data755 = copy(value = value * k)
  def addTag(t: String): Data755 = copy(tags = t :: tags)
  def put(k: String, v: String): Data755 = copy(meta = meta.updated(k, v))
  def merge(other: Data755): Data755 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data755 {
  given Ordering[Data755] = Ordering.by(_.id)
  def empty: Data755 = Data755(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data755 =
    Data755(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data755] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
