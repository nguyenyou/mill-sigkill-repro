package generated

final case class Data1358(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1358 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1358 = copy(value = value * k)
  def addTag(t: String): Data1358 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1358 = copy(meta = meta.updated(k, v))
  def merge(other: Data1358): Data1358 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1358 {
  given Ordering[Data1358] = Ordering.by(_.id)
  def empty: Data1358 = Data1358(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1358 =
    Data1358(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1358] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
