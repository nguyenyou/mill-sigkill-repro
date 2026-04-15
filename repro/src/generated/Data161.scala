package generated

final case class Data161(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data161 = copy(name = name.toUpperCase)
  def scale(k: Double): Data161 = copy(value = value * k)
  def addTag(t: String): Data161 = copy(tags = t :: tags)
  def put(k: String, v: String): Data161 = copy(meta = meta.updated(k, v))
  def merge(other: Data161): Data161 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data161 {
  given Ordering[Data161] = Ordering.by(_.id)
  def empty: Data161 = Data161(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data161 =
    Data161(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data161] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
