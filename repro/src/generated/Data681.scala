package generated

final case class Data681(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data681 = copy(name = name.toUpperCase)
  def scale(k: Double): Data681 = copy(value = value * k)
  def addTag(t: String): Data681 = copy(tags = t :: tags)
  def put(k: String, v: String): Data681 = copy(meta = meta.updated(k, v))
  def merge(other: Data681): Data681 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data681 {
  given Ordering[Data681] = Ordering.by(_.id)
  def empty: Data681 = Data681(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data681 =
    Data681(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data681] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
