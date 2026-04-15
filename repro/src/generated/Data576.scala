package generated

final case class Data576(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data576 = copy(name = name.toUpperCase)
  def scale(k: Double): Data576 = copy(value = value * k)
  def addTag(t: String): Data576 = copy(tags = t :: tags)
  def put(k: String, v: String): Data576 = copy(meta = meta.updated(k, v))
  def merge(other: Data576): Data576 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data576 {
  given Ordering[Data576] = Ordering.by(_.id)
  def empty: Data576 = Data576(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data576 =
    Data576(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data576] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
