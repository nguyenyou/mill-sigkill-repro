package generated

final case class Data1024(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1024 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1024 = copy(value = value * k)
  def addTag(t: String): Data1024 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1024 = copy(meta = meta.updated(k, v))
  def merge(other: Data1024): Data1024 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1024 {
  given Ordering[Data1024] = Ordering.by(_.id)
  def empty: Data1024 = Data1024(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1024 =
    Data1024(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1024] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
